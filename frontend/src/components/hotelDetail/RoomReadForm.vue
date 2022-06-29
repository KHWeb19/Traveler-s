<template>
<v-container>
    <table  style="width: 80%">
        <tr>
            <td>
                <h1 align="left"> 객실 소개 </h1>
            </td>
        </tr>
            <tr> <!-- 객실 란 컴포넌트 분리하여 작업 중!-->
                <td>
                    <v-container>
                       <v-col v-for="(item, i) in roomList" :key="i">
                        <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
                            align = "center"
                            style="margin: 10px; width: 100%; height: 200px;">

                        <v-col>
                            <v-row justify="center">
                            
                                <table id="inCard" style="width: 30%; height: 200px;">
                                    <tr>
                                        <td>
                                            <v-img  width="300px" height="160px"  :src="require(`@/assets/roomImg/${item.roomImgPath1}`)"/>
                                        </td>
                                    </tr>
                                </table>
                                <table id="inCard" style="width: 42%; height: 190px;">
                                    <tr>
                                        <td>
                                            <p>{{item.roomType}}</p>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <td>
                                            <p>{{item.personnel}}</p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <v-row >
                                                <span id="tagSpan1" v-for="(item, i) in item.roomInfo" :key="i" class="hotel_info">
                                            {{ "#" + item }}
                                            <!-- i 번째 item를 출력  -->
                                        </span> 
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
                                                        <v-dialog width="700px">
                                                        <template v-slot:activator="{ on }">
                                                            <v-btn
                                                                    :elevation="hover ? 16:2" v-on="on" dark>
                                                            상세보기
                                                            </v-btn>
                                                        </template>


                                                            <!-- slide를 넣어서 객실 사진 전부를 확인할 수 있도록 한다. -->
                                                                <div class="slide-10d">
                                                                        <v-container style="padding: 0px">
                                                                            <v-carousel cycle hide-delimiters class="cover">
                                                                            <v-carousel-item :src="require(`@/assets/roomImg/${item.roomImgPath1}`)"/>
                                                                            <v-carousel-item :src="require(`@/assets/roomImg/${item.roomImgPath2}`)"/>
                                                                            <v-carousel-item :src="require(`@/assets/roomImg/${item.roomImgPath3}`)"/>
                                                                            <v-carousel-item :src="require(`@/assets/roomImg/${item.roomImgPath4}`)"/>
                                                                            <v-carousel-item :src="require(`@/assets/roomImg/${item.roomImgPath5}`)"/>
                                                                            <v-carousel-item v-if="roomList.roomImgPath6" :src="require(`@/assets/roomImg/${item.roomImgPath6}`)"/>
                                                                            <v-carousel-item v-if="roomList.roomImgPath7" :src="require(`@/assets/roomImg/${item.roomImgPath7}`)"/>
                                                                            <v-carousel-item v-if="roomList.roomImgPath8" :src="require(`@/assets/roomImg/${item.roomImgPath8}`)"/>
                                                                            <v-carousel-item v-if="roomList.roomImgPath9" :src="require(`@/assets/roomImg/${item.roomImgPath9}`)"/>
                                                                            </v-carousel>
                                                                        </v-container>
                                                                </div>
                                                            <br>
                                                                <v-card-actions>
                                                                    <v-spacer></v-spacer>
                                                                    <v-btn>
                                                                        닫기
                                                                    </v-btn>
                                                                </v-card-actions>
                                                    </v-dialog>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <br>
                                                            <v-btn id="button"
                                                            @click="goReserv(mRoom.hotelNo, mRoom.roomNo)"
                                                            >
                                                            예약하기</v-btn>
                                                        </td>
                                    <!-- <v-btn v-if="체크인날짜 || 예약테이블.예약date || 마지막 숙박일" 인 경우> 예약불가 <v-btn/>  -->
                                                <!-- 근데 또 위에처럼 시나리오를 잡으면 2박이 아닌 무수한 경우에는 어떻게 하는거야... -->
                                                <!-- 이 중간 날짜들을 체크할 수 있는 방법... ID, 닉네임 유효성 검사한 사람들 코드를 좀 봐야할듯 -->

                                    <!-- <v-btn v-if="check가 true면"> 예약불가 <v-btn/>  -->
                                                <!-- created에서 엑시오스 요청. 지금 검색된 내가 원한느 숙박날짜와 같은 날짜+같은 객실이 이미 예약 테이블에 포함되어 있는지 확인한다.
                                                    이미 같은 날짜+같은 객실이 DB에 있다면 check라는 bool타입 변수를 true로 변경해준다.-->
                                                <!-- 근데 이...중간의 여러 날짜를 체크할 수 있는 방법이 뭔지 모르겠다. ...1박이 아닌 경우를 어떻게 해야하나
                                                     검사 자체는 spring에서 for문 반복 돌려서 검사를 하면 모두 검사가 될 것 같긴 한데.
                                                     문제는 아직 검색창에서 체크인 체크아웃 날짜 외에는 정보가 잡히지 않는다는 것... -->

                                    <!-- <v-btn v-else> 예약불가 <v-btn/>  -->
                                                    </tr>
                                                </v-row>
                                            </v-col>
                                        </td>
                                    </tr>
                                </table>
                            </v-row>
                            </v-col>        
                        </v-card>
                        </v-col>
                    </v-container>
                <br>
            </td>
            </tr>
    </table>
</v-container>
</template>

<script>


export default {
    name: 'MRoomReadForm',
    components: {

    },
    props: {
        roomList: {
            type: Array
        }
    },
    methods: {
        goReserv () {

        },
    },
}
</script>


<style scoped>
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
</style>