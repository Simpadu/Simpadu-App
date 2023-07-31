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
    suspend fun  getProfile(): MahasiswaResponse



    @Multipart
    @POST("/api/upload")
    suspend fun changePhoto(
        @Part image: MultipartBody.Part,
    ): DefaultResponse

    @PUT("/api/updateMahasiswa")
    suspend fun updateMahasiswa(
        @Body updateProfile: RequestBody
    ): DefaultResponse


    @POST("/api/createWisuda")
    suspend fun createWisuda(
        @Body WisudaInput: RequestBody
    ): DefaultResponse

    @GET("/api/getWisuda")
    suspend fun getWisuda(): WisudaResponse


    @GET("/api/getAllPrestasi")
    suspend fun getAllPrestasi(): List<PrestasiResponse>

    @POST("/api/createPrestasi")
    suspend fun createPrestasi(
        @Body prestasiInput: RequestBody
    ): DefaultResponse

    @PUT("/api/updatePrestasi/{id}")
    suspend fun updatePrestasi(
        @Path("id") id: Int,
        @Body updatePrestasi: RequestBody
    ): DefaultResponse

    @DELETE("/api/deletePrestasi/{id}")
//    suspend fun deletePrestasi(): DefaultResponse
    suspend fun deletePrestasi(
        @Path("id") id: Int
    ):DefaultResponse

//    @DELETE("/api/deletePrestasi/{id}")
//    Call<DefaultResponse> deletePrestasi(@Path("id")int id):DefaulResponse


    @POST("/api/resetemail")
    suspend fun createResetEmail(
        @Body ResetEmailInput: RequestBody
    ):DefaultResponse

    @GET("/api/riwayatresetemail")
    suspend fun getResetEmail(): List<ResetEmailReaspon>

    @POST("/api/konsultasi/{semester}")
    suspend fun createKonsultasi(
        @Path("semester") semester: Byte,
        @Body konsultasiInput: RequestBody
    ): DefaultResponse
    @GET("/api/riwayatKonsultasi")
    suspend fun getRiwayatKonsultasi(): List<KonsultasiResponse>

    @GET("/api/jadwalkuliah")
    suspend fun getJadwalKuliah(): List<JadwalResponse>



    @GET("/api/ukt")
    suspend fun ukt(): UktResponse

    @GET("/api/riwayatukt")
    suspend fun riwayatUkt(): List<RiwayatUktResponse>

    @GET("/api/krs/{semester}")
    suspend fun getkrsbysemester(
        @Path("semester") krssemester: Int
    ): List<KrsResponse>







    @GET("/api/home")
    suspend fun getHome(): HomeResponse



    @GET("/api/presensidibuka")
    suspend fun getPresensi(): List<PresensiResponse>


    @GET("/api/presensi")
    suspend fun getRiwayatPresensi(): List<RiwayatPresensiResponse>


    @POST("/api/presensicreate/{id}")
    suspend fun createPresensiById(
        @Path("id") id: Int,
        @Body requestBody: RequestBody
    ):DefaultResponse


    @GET("/api/pengumuman")
    suspend fun getPengumuman(): List<PengumumanResponse>

    @GET("/api/pengumumanByID/{id}")
    suspend fun getPengumumanById(
        @Path("id") id: Int
    ): List<PengumumanResponse>

    @PUT("/api/updateWisuda")
    suspend fun updateWisuda(
        @Body updateWisuda: RequestBody
    ):DefaultResponse
}




