<template>
  <div class="about">
    <h1>Hello world {{ name }}</h1>
    <p>
      <label for="nome" id="labelnome">Nome:</label>
      <input type="text" v-model="name"/>
    </p>
   
    <p>
      <label for="senha" id="labelSenha">Senha: </label>
   <!-- <input type="text" :value='name' @input="alterarNome">-->
      <input type="text" v-model="senha">
    </p>
    

    <button @click="cadastrar">Cadastrar</button>

    <p v-if="name == 'Aluno'">A variavel é igual a aluno</p>
    <p v-else>A variavel não é igual a aluno</p>

    <table>
      <thead>
        <th>Nome</th>
        <th>Senha</th>
      </thead>
      <tbody>
        <tr v-for="usuario in usuarios" :key="usuario.nome">
          <td>{{ usuario.nome }}</td>
          <td>{{ usuario.senha }}</td>
          <td><button @click="remove(usuario)">Remover</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style>

</style>


<script setup lang="ts">
import { ref } from 'vue';

const name = ref<string>();
const senha = ref<string>();
const usuarios = ref([{nome: "João", senha: "123456"}, 
                      {nome: "Florinda", senha: "abacaxi"}])


function alterarNome(e: any){
  name.value = e.target.value;
}

function cadastrar(){
  if(name.value && senha.value){
    usuarios.value.push({nome: name.value, senha: senha.value});
    senha.value = ''
    name.value = ''
  }
}

function remove(usuario: {nome: string, senha: string}){
  const index = usuarios.value.findIndex(u => u.nome === usuario.nome && u.senha === usuario.senha);
  if (index !== -1) {
    usuarios.value.splice(index, 1);
}
}

function update(){
  for(let i = 0; i <10; i++){
    
  }
}

</script>