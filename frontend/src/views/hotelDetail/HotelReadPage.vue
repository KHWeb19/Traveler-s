<template>
    <div align="center">

        <h1>호텔 상세보기 페이지</h1>
        <hotel-read-form/>
    </div>
</template>

<script>
import HotelReadForm from '@/components/hotelDetail/HotelReadForm.vue'

export default {
    name: 'HotelReadPage',
    components: {
        HotelReadForm
    }
}
</script>


<style scoped>

</style>