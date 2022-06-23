<template>
  <div>
    <hotel-modify-form v-if="bmhotel" :bmhotel="bmhotel" @submit="onSubmit"/>
    <p v-else>안뜨고있는거임 하.....</p>
  </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import HotelModifyForm from '@/components/hotel/HotelModifyForm.vue'

export default {
    components: {
        HotelModifyForm,

    },
    props: {
        hotelNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['bmhotel'])
    },
    methods: {
        ...mapActions(['fetchBmHotel']),
        onSubmit (payload) {
            const { hotelName, hotelInfo, files } = payload

            axios.put(`http://localhost:7777/hotel/bm/${this.hotelNo}`,
                { hotelName, hotelInfo, files })
                    .then(res => {
                        alert('수정되었습니다.')
                        this.$router.push({
                            name: 'HotelReadPage',
                            params: { hotelNo: res.data.hotelNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('수정 실패하였습니다.')
                    })
        }
    },
    created () {
        this.fetchBmHotel(this.hotelNo)
                .catch(() => {
                    alert('DB 조회 실패')
                    this.$router.back()
                })
    }
}
</script>

<style>

</style>