<template>
  <div>
    <bm-side-bar/>
    <hotel-modify-form v-if="hotel" :hotel="hotel" @submit="onSubmit"/>
    <p v-else>안뜨고있는거임 하.....</p>
  </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import HotelModifyForm from '@/components/hotel/HotelModifyForm.vue'
import BmSideBar from '@/components/layout/BmSideBar.vue'

export default {
    components: {
        HotelModifyForm,
        BmSideBar
    },
    props: {
        hotelNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['hotel'])
    },
    methods: {
        ...mapActions(['fetchHotel']),
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
        this.fetchHotel(this.hotelNo)
                .catch(() => {
                    alert('DB 조회 실패')
                    this.$router.back()
                })
    }
}
</script>

<style>

</style>