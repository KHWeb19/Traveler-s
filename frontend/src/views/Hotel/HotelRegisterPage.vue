<template>
  <div>
    <side-bar/>
    <hotel-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import SideBar from '@/components/Layout/SideBar.vue'
import HotelRegisterForm from '@/components/hotel/HotelRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'HotelRegisterPage',
    components: {
        SideBar,
        HotelRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { hotelName, hotelInfo, postcode, address, detailAddress, extraAddress } = payload
            axios.post('http://localhost:7777/hotel/hotelRegister', { hotelName, hotelInfo, postcode, address, detailAddress, extraAddress })
            .then(() => {
                alert('등록 되었습니다.')

                /* this.$router.push({
                    name: ''
                }) */
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