<template>
    <v-container fluid>

            <v-card-title
            id="TagName"
            >
            태그스토리
            </v-card-title>
            <v-row justify="center">
                <v-btn v-for="(info, idx) in hotelInfo"
                :key="idx"
                @click="search(info)"
                rounded
                class="button1 b-color rot-1">#{{ info }}
                </v-btn>
            </v-row>


            <!-- 
                   <div class="slide-3d">
            <v-container>
                <swiper 
                    class="swiper" 
                    :options="swiperOption"
                >
                    <swiper-slide><img src=""/></swiper-slide>
                    <swiper-slide>Slide 2</swiper-slide>
                    <swiper-slide>Slide 3</swiper-slide>
                    <swiper-slide>Slide 4</swiper-slide>
                    <swiper-slide>Slide 5</swiper-slide>
                    <swiper-slide>Slide 6</swiper-slide>

                    <div class="swiper-pagination" slot="pagination">
                    </div>
                </swiper>
            </v-container>

            </div>-->
    </v-container>
</template>

<script>
import axios from 'axios'
//import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
//import 'swiper/css/swiper.css'

export default {
    name: 'TagSearch',
    components: {
        //Swiper,
        //SwiperSlide
        },
    props: {
        mHotels: {
            type: Array
        }
    },
    data () {
        return {
            hotelInfo:[
                '오션뷰',
                '이색적인',
                '바베큐그릴',
                '반려동물',
                '온천'
            ],
            swiperOption: {
                loop: true,
                slidesPerView: 3,
                spaceBetween: 20,
                grabCursor: true,
                pagination: {
                    el: '.swiper-pagination',
                    dynamicBullets: true
                },
            }
        }
    },
    methods : {
        search(info) {
            const word = info;
            console.log(word)
            axios.post('http://localhost:7777/search/tagSearch',  { word })
                    .then((res) => {
                        console.log("검색 성공")
                        console.log(res.data)
                        
                        this.$router.push({name: 'TagSearchPage',
                                    params: { searchList: res.data, word } })
                                    //searchList와 pageArray는 같은 결과가 저장되기 때문에
                                    //차후 최종 확인하였을 때 하나만 필요한 시나리오인 게 확실하다면
                                    //searchList를 삭제하도록 한다.
                                    //이 파일 말고 components/detailSearch/searchDetailSearch.vue, views/searchpage/SearchPage.vue도 확인하여 삭제할 것
                    .catch(() => {});
                })
                .catch(() => {
                alert("검색 실패");
            });
             
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
#TagName {
    justify-content: center;
}
</style>