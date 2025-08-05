package br.senai.sp.jandira.clienteapp.service

import br.senai.sp.jandira.clienteapp.model.cliente
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClienteService {
    @POST("clientes")
    fun cadastrarCliente(@Body cliente: cliente):Call<cliente>

    @GET("clientes")
    fun listarTodos(): Call<List<cliente>>
}