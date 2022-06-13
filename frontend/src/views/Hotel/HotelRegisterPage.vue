<template>
  <div>
    <side-bar/>
    <hotel-register-form/>
  </div>
</template>

<script>
import SideBar from '@/components/Layout/SideBar.vue'
import HotelRegisterForm from '../../components/hotel/HotelRegisterForm.vue'
// import axios from 'axios'

export default {
    name: 'HotelRegisterPage',
    components: {
        SideBar,
        HotelRegisterForm
    },/*
    methods: {
        onSubmit (payload) {
            const {} = payload
            axios.post('http://localhost:8080/hotel/hotelregister', {})
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
    */
}
</script>

<style>

</style>