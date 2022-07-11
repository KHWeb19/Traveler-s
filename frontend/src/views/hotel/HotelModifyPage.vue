<template>
  <div>
    <hotel-modify-form v-if="bmHotel" :bmHotel="bmHotel" @submit="onSubmit"/>
    <p v-else>로딩중입니다.</p>
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
        ...mapState(['bmHotel'])
    },
    methods: {
        ...mapActions(['fetchBmHotel']),
        onSubmit (payload) {
            const { hotelName, hotelInfo, hotelIntro, postcode, totalAddress, files } = payload

            let formData = new FormData()
            let hotel = {
                   hotelName,
                    hotelInfo,
                    hotelIntro,
                    postcode,
                    totalAddress,
            }

            formData.append('hotel',new Blob([JSON.stringify(hotel)],{type: "application/json"}))
            
            for (let i = 0; i <  files.length; i++) {
                formData.append('files',files[i].file)
            }

            console.log(files)

            axios.put(`http://localhost:7777/hotel/bm/${this.hotelNo}`,
                formData,{headers: {
                    'Content-Type' : 'multipart/form-data'
                }})
                    .then(res => {
                        alert('수정되었습니다.')
                        this.$router.push({
                            name: 'BHotelReadPage',
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