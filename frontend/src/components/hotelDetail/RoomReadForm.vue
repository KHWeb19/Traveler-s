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
                        <p>{{mRoom.roomName}}</p>
                    </td>
                </tr>
                <tr> 
                    <td>
                        <p>{{mRoom.personnel}}</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <v-row >
                             <span id="tagSpan1" v-for="(item, i) in mRoom.roomInfo" :key="i" class="hotel_info">
                                            {{ "#" + item }}
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
                                    <td>
                                        <v-btn id="button"
                                        @click="roomDetail(mRoom.boardNo, mRoom.id)"
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

<script>
export default {
    
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