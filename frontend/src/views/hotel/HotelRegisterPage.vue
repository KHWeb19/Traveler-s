<template>
  <div>
    <bm-side-bar/>
    <hotel-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import BmSideBar from '@/components/layout/BmSideBar.vue'
import HotelRegisterForm from '@/components/hotel/HotelRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'HotelRegisterPage',
    components: {
        BmSideBar,
        HotelRegisterForm,
    },
    methods: {
        onSubmit (payload) {
            const { hotelName, hotelInfo, postcode, totalAddress , files } = payload
            let formData = new FormData()
            let hotel = {
                    hotelName,
                    hotelInfo,
                    postcode,
                    totalAddress
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
                    name: 'HotelListPage'
                })
            })
            .catch(() => {
                alert('오류가 발생하였습니다.')
            })
        }
    }
}
</script>

<style>
</style>