<template>
  <div>
    <bm-side-bar/>
    <hotel-modify-form v-if="hotel" :hotel="hotel" @submit="onSubmit"/>
    <p v-else>로딩중 .......</p>
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
            const { hotelName, hotelInfo, files, notImage, fileNum } = payload

            axios.put(`http://localhost:7777/hotel/modify/${this.hotelNo}`,
                { hotelName, hotelInfo, files, notImage, fileNum  })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'HotelReadPage',
                            params: { hotelNo: res.data.hotelNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
}
</script>

<style>

</style>