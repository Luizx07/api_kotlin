package br.senai.sp.jandira.clienteapp.service

import br.senai.sp.jandira.clienteapp.model.cliente
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ClienteService {
    @POST("clientes")
    fun cadastrarCliente(@Body cliente: cliente):Call<cliente>

    @GET("clientes")
    fun listarTodos(): Call<List<cliente>>

    @GET("clientes/{id}")
    fun buscarPorId(@Path("id") codigo:Long): Call<cliente>

    @PUT("clientes")
    fun atualizar(@Body cliente: cliente): Call<cliente>

    @DELETE
    fun excluir(@Body cliente: cliente): Unit
}