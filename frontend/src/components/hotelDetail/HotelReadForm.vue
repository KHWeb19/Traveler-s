<template>
<div align="center">
    <v-container>
            <form @submit.prevent="onSubmit">

            <table style="width: 100%">

                <tr>
                <td>
                    <div class="slide-10d">
                        <v-container style="padding: 0px">
                            <swiper class="swiper position-relative" :options="swiperOption">
                                <swiper-slide><v-img  width="100%" height="400px" :src="require(`@/assets/hotelImage/hotel1.jpg`)"/></swiper-slide>
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
                    <!-- 숙소 이름 -->
                    <!-- 숙소 한줄 소개 -->
                    <h1>숙소 이름</h1>
                    <p>숙소 한줄 소개</p>
                </td>
                </tr>

                <tr>
                <td>
                    <!-- 객실 란 -->
                    <template>
                        <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
                            @click="registerRoom(room.boardNo, room.id)"
                            align = "center"
                            style="margin: 10px; width: 100%; height: 200px;">

                        <v-col sm = 4px>
                            <v-row justify="center">
                            
                                <table id="inCard" style="width: 30%">
                                    <tr>
                                        <td>
                                            <p>객실 이미지</p>
                                        </td>
                                    </tr>
                                </table>

                                <table id="inCard" style="width: 50%">
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
                                                <v-btn id="button">버튼</v-btn>
                                                <v-btn id="button">버튼</v-btn>
                                                <v-btn id="button">버튼</v-btn>
                                                <v-btn id="button">버튼</v-btn>
                                                <v-btn id="button">버튼</v-btn>
                                            </v-row>
                                        </td>
                                    </tr>
                                </table>

                                <table id="inCard" style="width: 10%">
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
                                </table>

                            </v-row>
                            </v-col>        
                        </v-card>
                    </template>
                </td>
                </tr>


                <hr align="center" style="width: 100%;">
                <!-- 이 숙소의 매력 포인트 태그 -->

                <tr>
                <td>
                    <v-col>
                        <v-row justify="center">
                            <v-btn id="button">버튼</v-btn>
                            <v-btn id="button">버튼</v-btn>
                            <v-btn id="button">버튼</v-btn>
                            <v-btn id="button">버튼</v-btn>
                            <v-btn id="button">버튼</v-btn>
                        </v-row>
                    </v-col>
                </td>
                </tr>

                <hr>
                <!-- 숙소 위치 -->

                <tr>
                <td>
                    <h4>숙소 위치</h4>
                    <p>oo시 oo구 oo동 어쩌고 저쩌고 133-1234</p>
                </td>
                </tr>

                <hr>

                <tr>
                <td>
                    <v-col>
                    <v-row>
                        <table style="width: 10%; height: 10%; margin-left:auto;">
                            <tr>
                                <p>이미지</p>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td>
                                    <h3>사업자명 확인 가능</h3>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p> 카톡으로 문의하기 </p>
                                </td>
                            </tr>
                        </table>
                    </v-row>
                    </v-col>
                </td>
                </tr>
                <!-- 사업자명 확인 가능 & 카톡으로 문의하기 -->

            </table>


            </form>
    </v-container>

</div>
</template>

<script>
export default {
    
}
</script>


<style scoped>
#inCard{
    border: 1px;
    color: black;
}
#button{
    margin: 10px;
}
</style>