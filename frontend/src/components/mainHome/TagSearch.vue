<template>
    <v-container fluid>
        <v-divider></v-divider>
        <section>
            <v-card-title class="justify-center" style="font-size:3em">테마 검색</v-card-title>
            <v-row align="center" justify="center">
                <v-btn v-for="(info, idx) in hotelInfo" :key="idx" @click="search(info)" rounded class="button1 b-color rot-1">#{{info}}</v-btn>

            </v-row>
        </section>
     
        <v-carousel cycle hide-delimiters class="cover">
        <v-carousel-item  v-for="(list,idx) in searchList" :key="idx" :src="require(`@/assets/hotelImg/${list.hotelImgPath1}`)"  >
            <v-row class="img" align="center" justify="center" >
            </v-row>
        </v-carousel-item>
         </v-carousel>
        
        <v-divider></v-divider>

                      
    </v-container>
</template>

<script>
import axios from 'axios'

export default {
    name: 'TagSearch',
    props: {
        hotels: {
            type: Array
        }
    },
    data () {
        return {
            hotelInfo:[
                '오션뷰',
                '테라스',
                '수영장',
                '전기차충전',
                '공항근처',
                '골프장',
                '무료주차',
                '바베큐그릴',
                '반려동물',
                '온천'
            ],
        }
    },
    methods : {
        search(info) {
            const keyWord = info
            console.log(keyWord)
            axios.post('http://localhost:7777/search',  { keyWord })
                    .then((res) => {
                        console.log("검색 성공")
                        console.log(res.data)
                        
                        this.$router.push({name: '',
                                    params: { searchList: res.data} })
                    })
             
        }
    },
  
}
</script>
<style scoped>

.button1 {
    display: inline-block;
    position: relative;
    border-radius: 3px;
    text-decoration: none;
    padding: .5em;
    margin: .5em;
    font-size: 2em;
    font-weight: bold;
    transition: all .5s;
}
.b-color,
.b-color:before {
    background: linear-gradient(35deg, rgba(0, 0, 0, 0.225) 0%, rgb(225, 225, 225) 100%);
}
.rot-1:hover {
    filter: hue-rotate(130deg);
}
.theme {
    width: 100%;
    margin: 2em;
}
.justify-center {
    margin: 1px;
    padding: 20px;
}
.v-divider {
    margin: 1px;
    padding: 5px;
}
.v-card-title {
    margin-top: 2%;
    margin-bottom: 1%;
    min-width: 300px;
}
.section{
    margin: 2%;
}
</style>