<template>
    <div class="about">
      <h1 id="hello">Usuário</h1>
      <p>
        <label for="nome" id="labelnome">Nome:</label>
        <input type="text" v-model="name"/>
      </p>
     
      <p>
        <label for="senha" id="labelSenha">Senha: </label>
     <!-- <input type="text" :value='name' @input="alterarNome">-->
        <input type="text" v-model="senha">
      </p>
      
  
      <button @click="createUser">Cadastrar</button>
      <button @click="getAllUsers">Buscar Usuários</button>

      <h5>{{ erro }}</h5>

   
      <table>
        <thead>
          <th>Id</th>
          <th>Nome</th>
        </thead>
        <tbody>
          <tr v-for="usuario in usuarios" :key="usuario.nome">
            <td>{{ usuario.id }}</td>
            <td>{{ usuario.nome }}</td>
            <td><button @click="remove(usuario)">Remover</button></td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <style>
  
  </style>
  
  
  <script setup lang="ts">

  import axios from 'axios';
  import { ref } from 'vue';
  import { onMounted } from 'vue';

  onMounted(() => {
    getAllUsers();
  });
  
  const name = ref<string>();
  const senha = ref<string>();
  const usuarios = ref([{id: 1, nome: "João", senha: "123456"}, 
                        {id: 1, nome: "Florinda", senha: "abacaxi"}])
  const erro = ref<string>()

  
  function alterarNome(e: any){
    name.value = e.target.value;
  }
  
  function remove(usuario: {nome: string, senha: string}){
    const index = usuarios.value.findIndex(u => u.nome === usuario.nome && u.senha === usuario.senha);
    if (index !== -1) {
      usuarios.value.splice(index, 1);
    }
    }

    async function getAllUsers(){
        usuarios.value = (await axios.get("/usuarios")).data;
    }
    
    async function createUser(){

        try{
            const body = {
                nome: name.value,
                senha: senha.value
            };
            name.value = ''
            senha.value = ''
            await axios.post("/usuarios", body);
            getAllUsers();
        }catch(ex){
            erro.value = (ex as Error).message
        }
        
    }
  </script>