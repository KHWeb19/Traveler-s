<template>
  <!-- 숙소 등록 페이지-->
  <div>
      <p>*은 필수 입력사항입니다.</p>
  </div>
</template>

<script>

import HotelRegisterForm from '@/components/Hotel/HotelRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'HotelRegisterPage',
    components: {
        HotelRegisterForm
    },
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
}
</script>

<style>

</style>