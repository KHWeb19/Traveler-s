<template>
    <div align="center">

        <h1>호텔 상세보기 페이지</h1>
        <hotel-read-form v-if="mHotel" :mHotel="mHotel"/>
        <p v-else> 로딩중......</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import HotelReadForm from '@/components/hotelDetail/HotelReadForm.vue'

export default {
    name: 'HotelReadPage',
    props: {
        hotelNo: {
            type: String,
            required: true
        }
    },
    components: {
        HotelReadForm
    },
    computed: {
        ...mapState(['mHotel'])
    },
    created () {
        this.fetchMHotel(this.hotelNo)
                .catch(() => {
                    alert('숙소 상세보기 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchMHotel']),        
    }
}
</script>


<style scoped>

</style>