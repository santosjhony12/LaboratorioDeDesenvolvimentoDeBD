import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

export const useUsuarioStore = defineStore('usuario', () => {
  const nomeUsuario = ref<string>()
  const senhaUsuario = ref<string>()
  const token = ref<string>()
  const erro = ref<string>()


  async function login(nome:string, senha:string){

    try{
        const body = {
            
        };

        let response = await axios.post("/login", {
            nome: nome,
            senha: senha
        });
        nomeUsuario.value = nome
        token.value = response.data.token
        erro.value = ''
        
    }catch(ex){
        token.value = ''
        erro.value = (ex as Error).message
    }
    
}


  return { nomeUsuario, token, erro, login }
},{
    persist: true
})
