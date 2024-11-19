<template>
    <div class="container-aluno">
        <h1>Gerenciamento de Alunos</h1>
        <div class="button-buscar-todos">
            <button @click="getAllAlunos" >Buscar Todos</button>

        </div>

        <h4 v-if="showMessage" class="alerta" :class="{'error': isError, 'confirmation': !isError}">{{ message }}</h4>
        <div class="cadastro-form">
            <h3>Cadastrar aluno</h3>
            <label for="ra">RA:</label>
            <input type="number" v-model="alunoCadastro.ra">

            <label for="nomeCompleto">Nome Completo:</label>
            <input type="text" v-model="alunoCadastro.nomeCompleto">

            <label for="emailInstitucional">E-mail institucional:</label>
            <input type="text" v-model="alunoCadastro.emailInstitucional">

            <label for="dataMatricula">Data de matricula(opcional):</label>
            <input type="date" v-model="alunoCadastro.dataMatricula">

            <label for="dataTermino">Data de Término(opcional):</label>
            <input type="date" v-model="alunoCadastro.dataTermino">

            <button @click="cadastrarAluno">Cadastrar</button>
            
        </div>

       <div class="buscar-form">
            <h3>Buscar Aluno</h3>
            <label for="nomeCompleto">Nome Completo:</label>
            <input type="text" v-model="buscaNome">

            <label for="dataTermino">Data de Término:</label>
            <input type="date" v-model="buscaDataTermino">

            <button @click="buscarAluno">Buscar</button>
       </div> 

        <h3>Alunos Cadastrados</h3>
        <div v-if="alunos.length > 0">
            <table>
                <tr>
                    <th>RA</th>
                    <th>Nome Completo</th>
                    <th>E-mail Institucional</th>
                    <th>Situação</th>
                </tr>
                <tr v-for="aluno of alunos">
                    <td>{{ aluno.ra }}</td>
                    <td>{{ aluno.nomeCompleto }}</td>
                    <td v-if="aluno.emailInstitucional == null">-</td>
                    <td v-else>{{ aluno.emailInstitucional }}</td>
                    <td v-if="aluno.emailInstitucional == null">Pendente</td>
                    <td v-else>OK</td>
                </tr>
                
            </table>
        </div>
        <div v-else>
            <h4>Nenhum aluno encontrado.</h4>
        </div>

    </div>
</template>

<script setup lang="ts">
import axios from 'axios';
import { onMounted, ref } from 'vue';

const isError = ref<boolean>();
const alunos = ref<Aluno[]>([]);
const message = ref<string>('');
const showMessage = ref<boolean>(false);
const alunoCadastro = ref<Aluno>({
    id: null,
    nomeCompleto: null,
    emailInstitucional: null,
    dataMatricula: null,
    dataTermino: null,
    ra: null,
});

const buscaNome = ref<string | null>('');
const buscaDataTermino = ref<string | null>('');

interface Aluno {
    id: number | null,
    nomeCompleto: string | null,
    emailInstitucional: string | null,
    dataMatricula: string | null,
    dataTermino: string | null,
    ra: number | null
}

const getAllAlunos = async () => {
    try{
        const response = await axios.get("http://localhost:8080/aluno");

        if(response.status == 200){
            alunos.value = response.data
        }else{
            isError.value = true;
            emitirAlerta("Houve algum erro na requisição. Tente novamente");
        }
    }catch(error){
        isError.value = true;
        emitirAlerta("Houve algum erro na requisição. Tente novamente");
    }
}

const cadastrarAluno = async () => {
    try{
        if(alunoCadastro.value.nomeCompleto == null ||
            alunoCadastro.value.nomeCompleto.trim() == ""
        ){
            isError.value = true;
            emitirAlerta("O nome não pode ser nulo.");
        }else{
            const response = await axios.post("http://localhost:8080/aluno", alunoCadastro.value);

            if(response.status == 200){
                
                isError.value = false;
                emitirAlerta(message.value = "Aluno cadastrado com sucesso!");
                getAllAlunos();
            }else{
                isError.value = true;
                emitirAlerta(message.value = "Não foi possivel realizar o cadastro!");
            }
        }
    }catch{
        isError.value = true;
        emitirAlerta(message.value = "Não foi possivel realizar o cadastro!");
    }
    limparInputs();
}

const buscarAluno = async () => {
    try{
        if(buscaDataTermino.value == null || buscaNome.value == "" || buscaNome.value == null || buscaDataTermino.value == ""){
            isError.value = true;
            emitirAlerta("Nome e Data termino não pode ser nulo para busca.");
        }else{
            const response = await axios.get(`http://localhost:8080/aluno/buscaNome/${buscaDataTermino.value}/${buscaNome.value}`);
            
            if(response.status == 200){
                alunos.value = response.data;
            }else{
                isError.value = true;
                emitirAlerta("Não foi possivel realizar a busca.");
            }
        }
        
    }catch(error){
        isError.value = true;
        emitirAlerta("Não foi possivel realizar a busca.");
    }
    limparInputs();
}
onMounted(() =>{
    getAllAlunos();
})

const emitirAlerta = (msg : string) =>{
    message.value = msg;
    showMessage.value = true;

    setTimeout(() => {
        showMessage.value = false;
        message.value = '';
    }, 3000);
}

const limparInputs = () => {
    alunoCadastro.value.dataMatricula = null;
    alunoCadastro.value.dataTermino = null;
    alunoCadastro.value.emailInstitucional = null;
    alunoCadastro.value.nomeCompleto = null;
    alunoCadastro.value.ra = null;
    buscaDataTermino.value = null;
    buscaNome.value = null;
}

</script>

<style scoped>
.cadastro-form, .buscar-form{
    display: flex;
    flex-direction: column;
    margin: 0 0 2em 0;
}
.alerta, h1{
    text-align: center;
}
.error{
    color: red;
}
.confirmation{
    color: green;
}
button{
    margin-top: 2vh;
    color: black;
    padding: 1em 3em;
    border: none;
    cursor: pointer
}
button:hover{
    background-color: rgb(191, 255, 214);
}
.button-buscar-todos{
    justify-content: end;
    display: flex;
}
input{
    padding: 0.8em 2em;
}

</style>