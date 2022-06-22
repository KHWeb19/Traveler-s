<template>
    <div align="center">

        <h1>호텔 상세보기 페이지</h1>
        <hotel-read-form v-if="hotel" :hotel="hotel"/>
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
        ...mapState(['hotel'])
    },
    created () {
        this.fetchHotel(this.hotelNo)
                .catch(() => {
                    alert('숙소 상세보기 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchHotel']),        
    }
}
</script>


<style scoped>

</style>