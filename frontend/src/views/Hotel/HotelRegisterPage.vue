<template>
  <div>
    <!-- side bar-->
    <side-bar/>
    <hotel-register-form/>
    <div class="hotelname">
        <h3>기본정보</h3>
        <p>*은 필수 입력사항입니다.</p>
    </div>
    <div class="hotelInfo">
        <h3>시설정보</h3>
    </div>
    <div class="hotelAddress">
        <h3>위치정보</h3>
    </div>
    <div class="hotelImg">
        <h3>이미지</h3>
    </div>
  </div>
</template>

<script>
import SideBar from '@/components/Layout/SideBar.vue'
import HotelRegisterForm from '@/components/Hotel/HotelRegisterForm.vue'
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