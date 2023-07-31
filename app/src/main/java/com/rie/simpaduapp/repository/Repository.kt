package com.rie.simpaduapp.repository

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.rie.simpaduapp.base.*
import com.rie.simpaduapp.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
import org.json.JSONObject
import java.io.InputStream
import java.time.LocalDate
import com.rie.simpaduapp.base.Result

class Repository(private val apiService: ApiService) {

    fun login(nim: String, password: String): LiveData<Result<AuthResponse>> = liveData {
        val json = JSONObject()
        json.put("nim", nim)
        json.put("password", password)
        val requestBody = json.toString().toRequestBody("application/json".toMediaTypeOrNull())
        emit(Result.Loading)
        try {
            val response = apiService.login(requestBody)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.e(TAG, "Login: ${e.message.toString()}")
            emit(Result.Error(e.message.toString()))
            }
        }


    fun logout(): LiveData<Result<DefaultResponse>> = liveData {
        try {
            val response = apiService.logout()
            Log.d(TAG, response.toString())
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.e(TAG, "logoutRepository: ${e.message.toString()}")
        }
    }


    fun createPrestasi(
        nama_prestasi: String, tingkatan_lomba: TingkatanLombaEnum, jenis_peserta: JenisPesertaEnum,
        jumlah_peserta: Int, capaian_prestasi: CapaianPrestasiEnum, tanggal_lomba: LocalDate,
        pembina: Int, bukti_prestasi: String
    ): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject().apply {
            put("nama_prestasi", nama_prestasi)
            put("tingkatan_lomba", tingkatan_lomba.name)
            put("jenis_peserta", jenis_peserta.name)
            put("jumlah_peserta", jumlah_peserta)
            put("capaian_prestasi", capaian_prestasi.name)
            put("tanggal_lomba", tanggal_lomba.toString())
            put("pembina", pembina)
            put("bukti_prestasi", bukti_prestasi)
        }
        val requestBody = json.toString().toRequestBody("application/json".toMediaTypeOrNull())
        Result.Loading
        try {
            val response = apiService.createPrestasi(requestBody)
            emit(Result.Success(response))
        } catch (e: IOException) {
            emit(Result.Error(e.message.toString()))
            }
        }


    fun updateProfile(
        nama: String,tempat_lahir: String,  no_hp: String, email: String, alamat: String,
        nama_ibu: String, nama_ayah:String, kecamatan:String, kelurahan:String
    ): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject()
        json.put("nama", nama)
        json.put("tempat_lahir", tempat_lahir)
        json.put("no_hp", no_hp)
        json.put("email", email)
        json.put("alamat", alamat)
        json.put("nama_ibu", nama_ibu)
        json.put("nama_ayah", nama_ayah)
        json.put("kecamatan", kecamatan)
        json.put("kelurahan", kelurahan)
        val requestBody = json.toString().toRequestBody("application/json".toMediaType())
        emit(Result.Loading)
        try {
            val respone = apiService.updateProfile(requestBody)
            Log.d(TAG, respone.toString())
            emit(Result.Success(respone))
        } catch (e: Exception) {
            Log.e(TAG, "updateProfile: ${e.message.toString()}")
            }
    }
    fun createResetEmail(
        keterangan :String
    ): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject()
        json.put("keterangan", keterangan)
        val requestBody = json.toString().toRequestBody("application/json".toMediaTypeOrNull())
        emit(Result.Loading)
        try {
            val response = apiService.createResetEmail(requestBody)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
            }
    }

    fun createPrestasi(
        nama_prestasi: String, tingkatan_lomba: String,jenis_peserta: String, jumlah_peserta: String,
        capaian_prestasi: String, tanggal_lomba: String
    ): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject()
        json.put("nama_prestasi", nama_prestasi)
        json.put("tingkatan_lomba", tingkatan_lomba)
        json.put("jenis_peserta", jenis_peserta)
        json.put("jumlah_peserta", jumlah_peserta)
        json.put("capaian_prestasi", capaian_prestasi)
        json.put("tanggal_lomba", tanggal_lomba)
        val requestBody = json.toString().toRequestBody("application/json".toMediaTypeOrNull())
        emit(Result.Loading)
        try {
            val response = apiService.createPrestasi(requestBody)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.e(TAG, "createPresensi: ${e.message.toString()}")
            emit(Result.Error(e.message.toString()))
        }
    }

    fun createPresensi(
        status :String
    ): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject()
        json.put("status", status)
        val requestBody = json.toString().toRequestBody("application/json".toMediaTypeOrNull())
        emit(Result.Loading)
        try {
            val response = apiService.createResetEmail(requestBody)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }




    fun getProfile(): Flow<MahasiswaResponse> = flow {
        val response = apiService. getProfile()
        val responseData = mutableStateOf("")
        responseData.value = response.nama.toString()
        emit(response)
    }


    fun getAllPengumuman(): Flow<List<PengumumanResponse>> = flow {
        val response = apiService.getPengumuman()
        emit(response)
    }





    fun getHome(): Flow<HomeResponse> = flow {
        try {
            val responseData = mutableStateOf("")
            val response = apiService.getHome()
            responseData.value = response.minggu.toString()
            responseData.value = response.status_mahasiswa.toString()
            responseData.value = response.total_sks.toString()
            responseData.value = response.ipk.toString()
            emit(response)
        } catch (e: Exception) {
            Log.e(TAG, "getHome: ${e.message.toString()}")
            }
    }




    fun getPresensi() = flow<List<PresensiResponse>> {
        val response = apiService.getPresensi()
        emit(response)
    }

    fun getRiwayatPresensi() = flow<List<RiwayatPresensiResponse>> {
        val response = apiService.getRiwayatPresensi()
        emit(response)
    }


    fun getAllPrestasi(): Flow<List<PrestasiResponse>> = flow {
        val response = apiService.getAllPrestasi()
        emit(response)
    }



    fun updatePrestasi(
       id: Int, nama_prestasi: String, tingkatan_lomba: String,jenis_peserta: String, jumlah_peserta: Int,
        capaian_prestasi: String, tanggal_lomba: String, pembina: String
    ): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject()
        json.put("nama_prestasi", nama_prestasi)
        json.put("tingkatan_lomba", tingkatan_lomba)
        json.put("jenis_peserta", jenis_peserta)
        json.put("jumlah_peserta", jumlah_peserta)
        json.put("capaian_prestasi", capaian_prestasi)
        json.put("tanggal_lomba", tanggal_lomba)
        json.put("pembina", pembina)
        val requestBody = json.toString().toRequestBody("application/json".toMediaType())
        emit(Result.Loading)
        try {
            val respone = apiService.updatePrestasi(id,requestBody)
            Log.d(TAG, respone.toString())
            emit(Result.Success(respone))
        } catch (e: Exception) {
            Log.e(TAG, "updatePrestasi: ${e.message.toString()}")
            }
    }


    suspend fun changePhoto(uri: InputStream): Result<DefaultResponse> =
        try {
            val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), uri.readBytes())
            val imageMultiPart =
                MultipartBody.Part.createFormData("image", "mahasiswa",requestFile)
            val response = apiService.changePhoto(imageMultiPart)
            Result.Success(response)
        } catch (e: Throwable) {
            e.printStackTrace()
            Result.Error(e.message.toString())
        } finally {
            withContext(Dispatchers.IO) {
                uri.close()
                }
            }


    suspend fun createById(id: Int, status: String) = flow<Result<DefaultResponse>> {
        val json = JSONObject()
        json.put("status", status)
        val jsonString = json.toString()
        val requestBody = jsonString.toRequestBody("application/json".toMediaTypeOrNull())

        try {
            val response = apiService.createPresensiById(id, requestBody)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }




    fun createPrestasi(
        nama_prestasi: String, tingkatan_lomba: String,jenis_peserta: String, jumlah_peserta: Int,
        capaian_prestasi: String
    ): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject()
        json.put("nama_prestasi", nama_prestasi)
        json.put("tingkatan_lomba", tingkatan_lomba)
        json.put("jenis_peserta", jenis_peserta)
        json.put("jumlah_peserta", jumlah_peserta)
        json.put("capaian_prestasi", capaian_prestasi)
        val requestBody = json.toString().toRequestBody("application/json".toMediaTypeOrNull())
        emit(Result.Loading)
        try {
            val response = apiService.createPrestasi(requestBody)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.e(TAG, "createPrestasi: ${e.message.toString()}")
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getPrestasi(): Flow<List<PrestasiResponse>> = flow {
        val response = apiService.getAllPrestasi()
        emit(response)
    }

    fun updatePrestasi(
        id: Int, nama_prestasi: String, tingkatan_lomba: String,jenis_peserta: String, jumlah_peserta: Int,
        capaian_prestasi: String
    ): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject()
        json.put("nama_prestasi", nama_prestasi)
        json.put("tingkatan_lomba", tingkatan_lomba)
        json.put("jenis_peserta", jenis_peserta)
        json.put("jumlah_peserta", jumlah_peserta)
        json.put("capaian_prestasi", capaian_prestasi)
        val requestBody = json.toString().toRequestBody("application/json".toMediaType())
        emit(Result.Loading)
        try {
            val respone = apiService.updatePrestasi(id, requestBody)
            Log.d(TAG, respone.toString())
            emit(Result.Success(respone))
        } catch (e: Exception) {
            Log.e(TAG, "updatePrestasi: ${e.message.toString()}")
        }
    }


    fun updateWisuda(
        pengalaman_organisasi: String, pengalaman_pelatihan: String, pengalaman_prestasi: String,
        nama_ayah: String, alamat_ortu: String,judul_tugas_akhir:String,tanggal_ujian:String
    ): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject()
        json.put("pengalaman_organisasi", pengalaman_organisasi)
        json.put("pengalaman_pelatihan", pengalaman_pelatihan)
        json.put("pengalaman_prestasi", pengalaman_prestasi)
        json.put("nama_ayah", nama_ayah)
        json.put("alamat_ortu", alamat_ortu)
        json.put("judul_tugas_akhir", judul_tugas_akhir)
        json.put("tanggal_ujian", tanggal_ujian)
        val requestBody = json.toString().toRequestBody("application/json".toMediaType())
        emit(Result.Loading)
        try {
            val respone = apiService.updateWisuda(requestBody)
            Log.d(TAG, respone.toString())
            emit(Result.Success(respone))
        } catch (e: Exception) {
            Log.e(TAG, "updateWisuda: ${e.message.toString()}")
            }
        }

    fun updateMagang(nama:String, judul:String, tempat_magang:String): LiveData<Result<DefaultResponse>> = liveData {
        val json = JSONObject()
        json.put("nama", nama)
        json.put("judul", judul)
        json.put("tempat_magang", tempat_magang)
        val requestBody = json.toString().toRequestBody("application/json".toMediaType())
        emit(Result.Loading)
        try {
            val respone = apiService.updateMagang(requestBody)
            Log.d(TAG, respone.toString())
            emit(Result.Success(respone))
        } catch (e: Exception) {
            Log.e(TAG, "updateMagang: ${e.message.toString()}")
        }
    }

    suspend fun deletePrestasi(id: Int) {
        apiService.deletePrestasi(id)
        }

    companion object {
        private const val TAG = "Repository"
    }

}