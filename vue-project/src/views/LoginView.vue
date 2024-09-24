<template>
    <div class="about">
      <h1 id="hello">Usuário</h1>
      <p>
        <label for="nome" id="labelnome">Nome:</label>
        <input type="text" v-model="nome"/>
      </p>
     
      <p>
        <label for="senha" id="labelSenha">Senha: </label>
     <!-- <input type="text" :value='nome' @input="alterarNome">-->
        <input type="text" v-model="senha">
      </p>
      
  
      <button @click="login">Login</button>

      <p v-if="store.erro">{{ store.erro }}</p>
      <p v-if="store.token">{{ store.token }}</p>
      <p></p>


    </div>
  </template>
  
  <style>
  
  </style>
  
  
  <script setup lang="ts">

  import axios from 'axios';
  import { ref } from 'vue';
  import { useUsuarioStore } from '@/stores/usuario'

  
  const nome = ref<string>("Aluno");
  const senha = ref<string>("12345");
  const store = useUsuarioStore()
  

  
    async function login(){
        store.login(nome.value, senha.value);
    }

  </script>