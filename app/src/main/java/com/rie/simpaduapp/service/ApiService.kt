package com.rie.simpaduapp.service

import com.rie.simpaduapp.base.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface ApiService {

    @POST("/api/login")
    suspend fun login(
        @Body loginInfo: RequestBody
    ): AuthResponse


    @DELETE("/api/logout")
    suspend fun logout(): DefaultResponse


    @PUT("/api/updateMahasiswa")
    suspend fun updateProfile(
        @Body updateProfile: RequestBody
    ): DefaultResponse

    @GET("/api/getMahasiswa")
    suspend fun userProfile(): MahasiswaResponse

    @POST("/api/createMagang")
    suspend fun createMagang(
        @Body incomeInput: RequestBody
    ): DefaultResponse
    @GET("/api/getMagang")
    suspend fun getMagang(): List<MagangResponse>

    @Multipart
    @POST("/api/upload")
    suspend fun changePhoto(
        @Part file: MultipartBody.Part,
    ): DefaultResponse

    @PUT("/api/updateMahasiswa")
    suspend fun updateMahasiswa(
        @Body updateProfile: RequestBody
    ): DefaultResponse

    @GET("/api/getMahasiswa")
    suspend fun getMahasiswa(): MahasiswaResponse

    @POST("/api/createWisuda")
    suspend fun createWisuda(
        @Body WisudaInput: RequestBody
    ): DefaultResponse

    @GET("/api/getWisuda")
    suspend fun getWisuda(): WisudaResponse

    @POST("/api/createPrestasi")
    suspend fun createPrestasi(
        @Body PrestasiInput: RequestBody
    ): DefaultResponse

    @PUT("/api/updatePrestasi/{id}")
    suspend fun updatePrestasi(
        @Body updatePrestasi: RequestBody
    ): DefaultResponse

    @GET("/api/getAllPrestasi")
    suspend fun getPrestasi(): PrestasiResponse

    @DELETE("/api/deletePrestasi/{id}")
    suspend fun deletePrestasi():DefaultResponse

    @POST("/api/resetemail")
    suspend fun createResetEmail(
        @Body ResetEmailInput: RequestBody
    ):DefaultResponse

    @POST("/api/konsultasi/{semester}")
    suspend fun createKonsultasi(
        @Path("semester") semester: Byte,
        @Body konsultasiInput: RequestBody
    ): DefaultResponse
    @GET("/api/riwayatKonsultasi")
    suspend fun getRiwayatKonsultasi(): List<KonsultasiResponse>

    @GET("/api/jadwalkuliah")
    suspend fun getJadwalKuliah(): List<JadwalResponse>


    @GET("/api/pengumuman/{jurusan_id}")
    suspend fun getPengumuman(
        @Path("jurusan_id") jurusanId: Int,
    ): List<PengumumanResponse>

    @GET("/api/ukt")
    suspend fun ukt(): UktResponse

    @GET("/api/riwayatukt")
    suspend fun riwayatUkt(): List<RiwayatUktResponse>

    @GET("/api/krs/{semester}")
    suspend fun getkrsbysemester(
        @Path("semester") krssemester: Int
    ): List<KrsResponse>

    @POST("/api/presensicreate/{id}")
    suspend fun createPresensi(
        @Body presensiInput: RequestBody
    ): DefaultResponse
    @GET("/api/presensi")
    suspend fun getPresensi(): List<PresensiResponse>

    @GET("/api/home")
    suspend fun getHome(): HomeResponse

}




