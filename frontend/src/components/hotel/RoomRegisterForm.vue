<template>
    <form @submit.prevent="onSubmit">

    <!-- 기본정보 -->
    <div class="room">
        <div>
            <h3>기본정보</h3>
            <p class="roomName">*은 필수 입력사항입니다.</p>
            <hr>
        <div>
            <label class="hotelNameLabel">* 호텔이름</label>
             <select  class="hotel-select" v-model="hotelNo">
                <option v-for="(hotel, idx) in hotelType" :key="idx" :value="hotel.hotelNo" > {{hotel.hotelName}}</option>
            </select>
        </div>
            <label class="roomNameLabel">* 객실이름</label>
            <input type="text" class="roomNameBox" v-model="roomName" placeholder="객실명을 입력해주세요."/>
        </div>
        <div>
            <label class="roomTypeLabel">* 객실유형</label>
            <input type="text" class="roomTypeBox" v-model="roomType" placeholder="객실유형을 입력해주세요."/>
        </div>
        <div>
            <label class="perssonel"> *객실인원</label> 
            <input class="numberBox" v-model="personnel" type="number" min="1" max="100" step="1">
        </div>
    </div>
    <!-- 시설정보 -->
    <div class="roomInfo">
        <h3>시설정보</h3>
        <hr>
        <div class="roomInfobox">
        <label>
            <input type="checkbox" name="roominfo" v-model="roomInfo" value="oceanView">오션뷰
        </label>
        <label>
            <input type="checkbox" name="roominfo" v-model="roomInfo" value="kitchen">주방
        </label>
        <label>
            <input type="checkbox" name="roominfo" v-model="roomInfo" value="wifi">와이파이
        </label>
        <label>
            <input type="checkbox" name="roominfo" v-model="roomInfo" value="freeParking">무료 주차
        </label>
        <label>
            <input type="checkbox" name="roominfo" v-model="roomInfo" value="bbqGrill">바베큐그릴
        </label>
        <label>
            <input type="checkbox" name="roominfo" v-model="roomInfo" value="swimmingPool">수영장
        </label>
        <label>
            <input type="checkbox" name="roominfo" v-model="roomInfo" value="showerRoom">샤워실
        </label>
        <label>
            <input type="checkbox" name="roominfo" v-model="roomInfo" value="pet">반려동물
        </label>
        <label>
            <input type="checkbox" name="roominfo" v-model="roomInfo" value="spa">온천
        </label>
        </div>
    </div>

   
    <!-- 이미지 -->
    <div class="roomImg">
        <h3>이미지</h3>
        <hr>
        <p class="roomImgLabel">* 숙소이미지</p>
    </div>

    <div v-if="this.files.length < 9">
        <input type="file" id="files" ref="files" 
                        multiple v-on:change="handleFilesUpload()" hidden />
        <v-icon>
            mdi-image-plus 
        </v-icon>
        <v-btn @click="chooseFile" text>
            이미지 첨부
        </v-btn> 
    </div>  
    <div v-else>
        <v-icon>
            mdi-close
        </v-icon>
        <v-btn @click="cancelFile" text>
            전체 취소
        </v-btn> 
    </div>
    <div>
         <table>
            <tr>
                <td v-for="(none, index) in notImage" :key="index" > 
                    <div v-if="files[index] == null">
                        <v-icon>
                            mdi-image
                        </v-icon>
                    </div>
                    <div v-else>
                         <img :src="files[index].preview" class="preview" width="100%" height="165px"/>
                         <v-icon @click="imgCancel(index)">
                            mdi-close
                        </v-icon>
                    </div>
                </td>
            </tr>

        </table>
    </div>
    
    <v-btn type="submit" class="btn1">저장하기</v-btn>
    <router-link :to="{ name: 'home' }" ><v-btn class="btn2">취소</v-btn></router-link>


</form>
</template>

<script>
export default {
    name: 'HotelRegisterForm',
     props: {
        hotelType: {
            type: Array,
            require: true,
        },
    },
    data () {
        return {
            roomName: '',
            roomType: '',
            roomInfo: [],
            files: [],
            notImage: ['','','','','','','','',''],
            fileNum: 0,
            totalAddress:'',
            personnel: '',
            hotelNo : ''
        }
    },
    methods: {
        onSubmit () {
            if(this.files.length < 5){
                alert('사진은 5장 이상 첨부해주세요')
            }else{
              
                console.log(this.hotelType)
                const { roomName, roomType, personnel,roomInfo, files, hotelNo } = this
                this.$emit('submit', { roomName, roomType, personnel, roomInfo, files , hotelNo})
            }
        },
           handleFilesUpload () {
            if(this.$refs.files.files.length > 9){
                alert("최대 9장 까지 가능 합니다")
                this.$refs.files.value = ''
                return
            }

            this.fileNum += this.$refs.files.files.length
            console.log(this.fileNum)
            if(this.fileNum < 10){
                        for (let i = 0; i < this.$refs.files.files.length; i++) {
                            this.files = [
                                ...this.files,
                                {
                                    file: this.$refs.files.files[i],
                                    preview: URL.createObjectURL(this.$refs.files.files[i])
                                }
                            ]
                        }      
                     
            }else{
                alert("최대 9장 까지 가능 합니다")
                console.log(this.fileNum)
                this.fileNum -= this.$refs.files.files.length
                this.$refs.files.value = ''
            }  
            
           },
        chooseFile() {
              document.getElementById("files").click()
        },
        cancelFile() {
            this.files = ''
            this.fileNum = 0
        },
        imgCancel(index) {
            //인덱스 어디부터 하나 삭제
            this.files.splice(index,1)
            this.fileNum -= 1
            console.log(this.files)
        }
    }
 
}
</script>

<style scoped>
h3 {
    margin: 10px;
}
.room {
    margin: 50px 50px 10px 50px;
}
.roomName {
    position: absolute;
    top: 8%;
    left: 87%;
    font-size: 12px;
}
.roomNameLabel,
.roomTypeLabel,
.perssonel,
.hotelNameLabel
 {
    font-size: 14px;
    margin-left: 50px;
}
.roomNameBox, .hotelNameBox:focus,
.roomTypeBox, .roomTypeBox:focus {
    width: 400px;
    padding: 5px 8px;
    margin: 30px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
    transition: .1s;
}
.numberBox, .numberBox:focus{
    width: 60px;
    padding: 5px 8px;
    margin: 30px;
    font-size: 13px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
    transition: .1s;
}
.roomInfo {
    margin: 30px 50px 0px 50px;
}
.roomInfobox {
    padding: 50px 0px 0px 0px;
    text-align: center;
    word-spacing: 50px;
    letter-spacing: 1px;
    font-size: 14px;
}
input[name="roominfo"] {
    position: relative;
    right: 5px;
    top: 1px;
}
.hotelAddress {
    margin: 50px 50px 10px 50px;
}
.roomImg {
    margin: 50px 50px 100px 50px;
}
.roomImgLabel  {
    font-size: 14px;
    position: relative;
    left: 50px;
    top: 30px;
}
.btn {
    text-align: center;
    word-spacing: 10px;
}
table {
    margin-left: auto;
    margin-right: auto;
    border-collapse: separate;
    border-spacing: 10px;
}

td {
    border: 1px solid black;
    width: 200px;
    height: 200px;
    text-align: center;
    
}
#files {
    margin: 30px
}
.btn1 {
    margin-left: 40%;
    margin-bottom: 30px;
    text-align: center;
    word-spacing: 15px;
    border: none;
    border-radius: 10px;
    padding: 10px 35px;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    cursor: pointer;
}
.btn2 {
    margin-left: 10px;
    margin-bottom: 30px;
    text-align: center;
    word-spacing: 15px;
    border: none;
    border-radius: 10px;
    padding: 10px 35px;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    cursor: pointer;
}
.hotel-select{
    margin-top: 10px;
    margin-left: 30px;
    width: 200px;
    height: 30px;
    border-radius: 2pt;
    box-shadow: 0 0 0 1pt grey;
    outline: none;
    transition: .1s;

}
</style>