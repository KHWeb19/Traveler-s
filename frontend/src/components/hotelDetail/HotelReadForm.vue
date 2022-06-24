<template>
<div align="center">
    <v-container>
            <form @submit.prevent="onSubmit">

            <table style="width: 80%">

                <tr>
                <td>
                    <div class="slide-9img">
                        <v-container style="padding: 0px">
                            <v-carousel cycle hide-delimiters class="cover">
                            <v-carousel-item :src="require(`@/assets/hotelImg/${mHotel.hotelImgPath1}`)"/>
                            <v-carousel-item :src="require(`@/assets/hotelImg/${mHotel.hotelImgPath2}`)"/>
                            <v-carousel-item :src="require(`@/assets/hotelImg/${mHotel.hotelImgPath3}`)"/>
                            <v-carousel-item :src="require(`@/assets/hotelImg/${mHotel.hotelImgPath4}`)"/>
                            <v-carousel-item :src="require(`@/assets/hotelImg/${mHotel.hotelImgPath5}`)"/>
                            <v-carousel-item v-if="mHotel.hotelImgPath6" :src="require(`@/assets/hotelImg/${mHotel.hotelImgPath6}`)"/>
                            <v-carousel-item v-if="mHotel.hotelImgPath7" :src="require(`@/assets/hotelImg/${mHotel.hotelImgPath7}`)"/>
                            <v-carousel-item v-if="mHotel.hotelImgPath8" :src="require(`@/assets/hotelImg/${mHotel.hotelImgPath8}`)"/>
                            <v-carousel-item v-if="mHotel.hotelImgPath9" :src="require(`@/assets/hotelImg/${mHotel.hotelImgPath9}`)"/>
                            </v-carousel>
                        </v-container>
                    </div>
                </td>
                </tr>

                <br>

                <tr>
                <td>
                    <h1>{{mHotel.hotelName}}</h1> <!-- 숙소 이름 -->
                    <p>{{mHotel.hotelIntro}}</p> <!-- 숙소 한줄 소개 -->
                </td>
                </tr>

                <br>

                <tr> <!-- 검색 조건 -->
                <td>
                    <h3>검색 조건</h3>
                    <!-- 객실 선택 -->
                    <!-- 검색페이지의 달력, 인원수 확인되어야 함. 서치 페이지 재활용하면 됨. -->
                    
                </td>
                </tr>


                <tr> <!-- 객실 란 컴포넌트 분리하여 작업 중!-->
                <td>
                    <room-read-form/>
                    <br>
                </td>
                </tr>


                <hr align="center" style="width: 100%;">
                
                <tr> <!-- 이 숙소의 매력 포인트 태그 -->
                <td>
                    <br>
                    <div align="center">
                    <table style="width: 70%">
                        <tr>
                            <td>
                                <v-col>
                                       <!-- hotelInfo라는 자료의 데이터 갯수만큼 반복이 된다. data 변수명은 item이라고 해준다.  -->
                                       <!-- key의 용도는 반복문 돌린 요소를 컴퓨터가 구분하기 위한 것. 반복문 돌면서 변하는 숫자/문자   -->
                                        <!-- 작명 두개 할 시(데이터 변수, 1씩 증가하는 정수 변수) / 이때 key에는 보통 정수 변수를 입력   -->
                                    <v-row justify="center">
                                        <span id="tagSpan2" v-for="(item, i) in mHotel.hotelInfo" :key="i" class="hotel_info">
                                            {{ "#" + item }}
                                            <!-- i 번째 item를 출력  -->
                                        </span>   
                                    </v-row>
                                </v-col>
                            </td>
                        </tr>
                    </table>
                    </div>
                    <br>
                </td>
                </tr>

                <hr>               

                <tr>
                <td>
                    <br>
                        <h3>숙소 위치</h3>
                        <p>{{mHotel.totalAddress}}</p>
                    <br>
                        <kakao-map-api/>
                    <br>
                </td>
                </tr>

                <hr>

                <tr> <!-- 사업자명 확인 가능 & 카톡으로 문의하기 -->
                <td>
                    <br>
                    <v-col>
                    <v-row justify="right">
                        <table style="margin-left:auto; margin-right: 10px;">
                            <tr>
                                <v-img id="myImg" :src="require(`@/assets/hotel.jpg`)"/>
                            </tr>
                        </table>
                        <table style="width: 180px; margin-right: 10px;">
                            <tr>
                                <td>
                                    <h3>{{mHotel.writer}}</h3>
                                </td>
                            </tr>
                            <tr>
                                <td text onclick="window.open('https://open.kakao.com/o/siza2rWb')">
                                    
                                    <p> <v-icon>mdi-chat-question-outline</v-icon> 카톡으로 문의하기 </p>
                                </td>
                            </tr>
                        </table>
                    </v-row>
                    </v-col>
                </td>
                </tr>                

                <hr>

                <br>
                <tr> <!-- 리뷰란 -->
                    <td>
                        <h3>고객 리뷰</h3>
                        <br>
                        <v-col>
                        <v-row justify="center">
                            <table style="width: 95%">
                                <tr>
                                    <td>
                                        <p>★★★★★ &ensp;|&ensp; 고객명</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <p>2022.05.11 &ensp;|&ensp; 객실종류</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td >
                                        <p>내집처럼 편안하게 머물다 갑니다~~주인분께서 친절하시고 비대면 체크인이라 너무 편안합니다
                                            따뜻하고 잠자리도 편안 합니다
                                            맛집도 알려주셔서 맛난곳에서 식사도 해결하고  아들과 둘만의 여행의 좋은 추억이 되었습니다.♡
                                            다음에 다시 제주도에 오면 다시 꼭 머물고 싶어요</p>
                                    </td>
                                </tr>
                            </table>
                        </v-row>
                        </v-col>
                    </td>
                </tr>

            </table>


<br>
            </form>
    </v-container>

</div>
</template>

<script>
import KakaoMapApi from '@/components/hotelDetail/KakaoMapApi.vue'
import RoomReadForm from './RoomReadForm.vue'

export default {
    name: 'MHotelReadForm',
    components: {
        KakaoMapApi,
        RoomReadForm
    },
    data() {
        return {
            hotelInfo: [],
        }
    },
    props: {
        mHotel: {
            type: Object,
            required: true
        }
    },
    methods: {

    }
}

</script>


<style scoped>
#inCard{
    border: 1px;
    color: black;
    vertical-align: middle;
}
#button{
    margin-top: 10px;
    margin-bottom: 10px;
    margin-left: 20px;
    padding-left: 30px;
    padding-right: 30px;
}
#tagSpan2{    
    margin: 10px;
    padding: 6px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 5px;
    background-color: lightgray;
}
#myImg{
    width: 55px;
    height: 55px;
    border-radius: 25px;
}
</style>