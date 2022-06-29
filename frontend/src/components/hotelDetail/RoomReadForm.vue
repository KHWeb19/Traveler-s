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