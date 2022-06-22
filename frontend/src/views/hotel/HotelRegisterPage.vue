<template>
  <div>
    <bm-side-bar/>
    <hotel-register-form @submit="onSubmit"
                            :user="user"/>
  </div>
</template>

<script>
import BmSideBar from '@/components/layout/BmSideBar.vue'
import HotelRegisterForm from '@/components/hotel/HotelRegisterForm.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'HotelRegisterPage',
    components: {
        BmSideBar,
        HotelRegisterForm,
    },
    computed: {
        ...mapState(["user"])
    },
    methods: {
         ...mapActions(["setUser"]),
        onSubmit (payload) {
            const { hotelName, hotelInfo, postcode, totalAddress , files, writer } = payload
            console.log(writer)
            let formData = new FormData()
            let hotel = {
                    hotelName,
                    hotelInfo,
                    postcode,
                    totalAddress,
                    writer
            }

            formData.append('hotel',new Blob([JSON.stringify(hotel)],{type: "application/json"}))
            
            for (let i = 0; i <  files.length; i++) {
                formData.append('files',files[i].file)
            }
           
            axios.post('http://localhost:7777/hotel/hotelRegister', formData, {
                headers: {
                    'Content-Type' : 'multipart/form-data'
                }
            })
            .then(() => {
                alert('등록 되었습니다.')
                this.$router.push({
                    name: 'home'
                })
            })
            .catch(() => {
                alert('오류가 발생하였습니다.')
            })
        }
    },
    mounted() {
        this.setUser()
    
    },
}
</script>

<style>
</style>