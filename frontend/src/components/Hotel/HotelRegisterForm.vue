<template>
<form @submit.prevent="onSubmit">
    <label for="hotelName">숙소명</label>
    <input type="text" v-model="hotelName"/>
</form>
</template>

<script>
export default {
    name: 'HotelRegisterForm',
    data () {
        return {
            hotelName: '숙소명을 입력해주세요.',
            
        }
    }
}
</script>

<style>

</style>