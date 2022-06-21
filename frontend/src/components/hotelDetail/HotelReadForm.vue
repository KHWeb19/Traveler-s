<template>
<div align="center">
    <v-container>
            <form @submit.prevent="onSubmit">

            <table style="width: 80%">

                <tr>
                <td>
                    <div class="slide-10d">
                        <v-container style="padding: 0px">
                            <swiper class="swiper position-relative" :options="swiperOption">
                                <swiper-slide><v-img  width="100%" height="400px" :src="require(`@/assets/hotelImg/${hotel.hotelImgPath1}`)"/></swiper-slide>
                                <div class="swiper-pagination" slot="pagination"></div>
                                <div class="swiper-button-prev" slot="button-prev"></div>
                                <div class="swiper-button-next" slot="button-next"></div>
                            </swiper>
                        </v-container>
                    </div>
                </td>
                </tr>

                <br>

                <tr>
                <td>
                    <h1>{{hotel.hotelName}}</h1> <!-- 숙소 이름 -->
                    <p>{{hotel.hotelName}}</p> <!-- 숙소 한줄 소개 -->
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


                <tr> <!-- 객실 란 -->
                <td>
                    <template>
                        <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
                            align = "center"
                            style="margin: 10px; width: 100%; height: 200px;">

                        <v-col>
                            <v-row justify="center">
                            
                                <table id="inCard" style="width: 30%; height: 200px;">
                                    <tr>
                                        <td>
                                            <v-img  width="300px" height="160px" :src="require(`@/assets/hotel.jpg`)"/>
                                        </td>
                                    </tr>
                                </table>

                                <table id="inCard" style="width: 42%; height: 190px;">
                                    <tr>
                                        <td>
                                            <p>평수</p>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <td>
                                            <p>기준 n명, 최대 n명</p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <v-row >
                                                <span id="tagSpan1"># 욕조</span>
                                                <span id="tagSpan1"># 와이파이</span>
                                                <span id="tagSpan1"># 주차장</span>
                                                <span id="tagSpan1"># 주방</span>
                                                <span id="tagSpan1"># 세탁기</span>
                                                <span id="tagSpan1"># 건조기</span>
                                                <span id="tagSpan1"># 에어컨</span>                                               
                                                <span id="tagSpan1"># TV</span>
                                                <span id="tagSpan1"># 드라이기</span>
                                                <span id="tagSpan1"># 소화기</span>
                                            </v-row>
                                        </td>
                                    </tr>
                                </table>
                                <pr></pr>
                                <table id="inCard" style="width: 10%; height: 190px;">
                                    <tr>
                                        <td>
                                            <v-col>
                                                <v-row justify="right">
                                                    <tr>
                                                        <td>
                                                            <v-btn id="button"
                                                            @click="roomDetail(room.boardNo, room.id)"
                                                            >
                                                            상세보기</v-btn>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <v-btn id="button"
                                                            @click="goRegister()"
                                                            >
                                                            예약하기</v-btn>
                                                        </td>
                                                    </tr>
                                                </v-row>
                                            </v-col>
                                        </td>
                                    </tr>
                                </table>

                            </v-row>
                            </v-col>        
                        </v-card>
                    </template>
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
                                    <v-row justify="center">
                                        <span id="tagSpan2"># 오션뷰</span>
                                        <span id="tagSpan2"># 테라스</span>
                                        <span id="tagSpan2"># 수영장</span>
                                        <span id="tagSpan2"># 전기차충전</span>
                                        <span id="tagSpan2"># 공항근처</span>
                                        <span id="tagSpan2"># 골프장</span>
                                        <span id="tagSpan2"># 무료주차</span>
                                        <span id="tagSpan2"># 바베큐그릴</span>
                                        <span id="tagSpan2"># 반려동물</span>
                                        <span id="tagSpan2"># 펜션</span>                            
                                        <span id="tagSpan2"># 온천</span>
                                        <span id="tagSpan2"># 스키장</span>    
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

                <tr><!-- 숙소 위치 -->
                <td>
                    <br>
                        <h3>숙소 위치</h3>
                        <p>oo시 oo구 oo동 어쩌고 저쩌고 133-1234</p>
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
                                    <h3>사업자명</h3>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    
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
export default {
    name: 'HotelReadForm',
    props: {
        hotel: {
            type: Object,
            required: true
        }
    },
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
#tagSpan1{    
    margin: 10px;
    padding: 6px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 5px;
    background-color: lightgray;
    font-size: 12px;
    color: gray;
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