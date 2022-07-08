<template>
  <v-container>    
    <table style="width: 80%">

      <!-- 검색 컴포넌트 분리 원한다면 여기서부터-->
      <tr>
        <td>
          <h1 align="left">객실 소개</h1>
        </td>
        <!-- 검색창 -->
       <td align="right" id="searchBar">
            <v-row>
              <v-spacer></v-spacer>
              <!-- 수직상 top에 딱 맞춰져 있어서 검색바랑 버튼이 수평이 안맞아보임. 아마 cols 값 안고쳐서 그런 것도 있는듯 -->
                <v-col cols="12" xs="6" sm="3" md="3">
                    <v-menu class="menu1" :close-on-content-click="false" transition="scale-transition"
                        offset-y>
                        <template v-slot:activator="{ on, attrs }">
                            <v-text-field class="DateSearch"  label="날짜 선택" v-model="planDate"
                                prepend-icon="mdi-calendar" v-bind="attrs" v-on="on"
                                rounded solo readonly></v-text-field>
                        </template>
                        <v-date-picker v-model="dates" 
                                        :min="new Date(Date.now() - new Date().getTimezoneOffset() * 60000).toISOString().substr(0,10)" range
                                        >
                        </v-date-picker>
                    </v-menu>
                </v-col>
                <v-col cols="12" xs="12" sm="12" md="2">
                    <v-select v-model="personnel" :items="items" item-value="value" prepend-icon="mdi-bed" label="인원 선택" class="PickPeople" rounded solo>
                    </v-select>
                </v-col>
                <v-col cols="12" xs="1" sm="1" md="1">
                    <v-btn @click="searchRoom()" type="submit" value="Subscribe">
                        검색하기
                    </v-btn>
                </v-col>

                &ensp; &ensp; &ensp;
            </v-row>
        </td>
      </tr> 
      <!-- 여기까지 주석 혹은 삭제 -->


      <tr> <!-- 객실 란-->
        <td colspan="2">
          <v-container>
            <v-col v-for="(item, i) in mRooms" :key="i">
              <v-card
                align="center"
                style="margin: 10px; width: 100%; height: 200px"
              >
                <v-col>
                  <v-row justify="center"> <!-- justify 에러메세지 뜨더라도 이거 아니면 객실이 전체적으로
                                                가운데 정렬 될 방법이없기 때문에 이건 지우지 말아주세요... -->
                    <table id="inCard" style="width: 30%; height: 200px">
                      <tr>
                        <td>                      
                          <v-img
                            width="300px"
                            height="160px"
                            :src="require(`@/assets/roomImg/${item.roomImage[0]}`)"
                          />
                        </td>
                      </tr>
                    </table>
                    <table id="inCard" style="width: 42%; height: 190px">
                      <tr>
                        <td style="vertical-align: bottom;">
                          <v-row>
                            <h4>{{ item.roomType }}</h4> <p> &ensp;|&ensp; {{ item.personnel }}</p>
                          </v-row>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <v-row>
                            <span
                              id="tagSpan1"
                              v-for="(info, i) in item.roomInfo"
                              :key="i"
                              class="hotel_info"
                            >
                              {{ "#" + info }}
                              <!-- i 번째 item를 출력  -->
                            </span>
                          </v-row>
                        </td>
                      </tr>
                    </table>

                    <table id="inCard" style="width: 10%; height: 190px">
                      <tr>
                        <td>
                          <v-col>
                            <v-row>
                              <tr>
                                <v-dialog v-model="dialog" width="700px">
                                  <template v-slot:activator="{ on }">
                                    <v-btn id="button" v-on="on"> 상세보기 </v-btn>
                                  </template>
                                  <!-- slide를 넣어서 객실 사진 전부를 확인할 수 있도록 한다. -->
                                  <div class="slide-10d">
                                    <v-container style="padding: 0px">
                                      <v-carousel
                                        cycle
                                        hide-delimiters
                                        class="cover"
                                      >
                                        <v-carousel-item v-for="(image, index) in item.roomImage" :key="index"
                                        :src="require(`@/assets/roomImg/${image}`)" />
                                      </v-carousel>
                                    </v-container>
                                  </div>
                                  <br />
                                  <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn @click="cancel"> 닫기 </v-btn>
                                  </v-card-actions>
                                </v-dialog>
                              </tr>
                              <tr>
                                <td>
                                  <br />
                                  <v-btn
                                    id="button2"
                                    @click="
                                      goReserv(item)
                                    "
                                  >
                                    예약하기</v-btn
                                  >
                                </td>
                                <!-- <v-btn v-if="체크인날짜 || 예약테이블.예약date || 마지막 숙박일" 인 경우> 예약불가 <v-btn/>  -->
                                <!-- 근데 또 위에처럼 시나리오를 잡으면 2박이 아닌 무수한 경우에는 어떻게 하는거야... -->
                                <!-- 이 중간 날짜들을 체크할 수 있는 방법... ID, 닉네임 유효성 검사한 사람들 코드를 좀 봐야할듯 -->

                                <!-- <v-btn v-if="체크인날짜 <= 예약테이블.예약date < 마지막 숙박일" 인 경우> 예약불가 <v-btn/>  -->

                                <!-- <v-btn v-if="check가 true면"> 예약불가 <v-btn/>  -->
                                <!-- created에서 엑시오스 요청. 지금 검색된 내가 원하는 숙박날짜와 같은 날짜+같은 객실이 이미 예약 테이블에 포함되어 있는지 확인한다.
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
          <br />
        </td>
      </tr>
    </table>
  </v-container>
</template>

<script>
import axios from "axios"

export default {
  name: "RoomReadForm",
  components: {},
    data: () => ({
        dates: [],
        items: ['1', '2', '3', '4'],
        value: null,
        personnel: '',
        dialog: false,
        roomList: []
  }),
  props: {
    payload: {
      type : Object
    },
    mRooms: {
      type : Array
    },
    hotelNo: {
      type : String
    }
  },
    computed: {
        planDate () {
            if(this.dates.length == 2) {
                if(this.dates[0] >= this.dates[1]){
                    alert ('다시 선택하세요')
                    this.initDates()
                }
            }
            return this.dates.join(' ~ ')
        },
    },
  methods: {
    goReserv(item) {
      const params = {
        "roomId": item.roomNo,
        "price": item.price,
        "startDate": this.dates[0],
        "endDate": this.dates[1],
        "status": "PENDING"
      }
      console.log(params)
      axios.post("http://localhost:7777/reserve/user/makeReservation", params)
      .then((res) => {
        if (res.status){
          console.log(res.data)
          this.$router.push({ name: 'MReservPage', params: {no: res.data}})
        }
      })
      .catch(() =>{
        alert("이미 예약된 숙소입니다")
      })

    },
    initDates() {
        return this.dates = []
    },
    cancel(){
      this.dialog = false
    },
   
    searchRoom() {
        console.log(this.dates)
        const { dates, personnel } = this
        const hotelNo = this.hotelNo
        const payload = {dates, personnel, hotelNo}
        axios
        .post("http://localhost:7777/room/mem/list", payload)
        .then((res) => {
          console.log(res.data);
          this.$store.state.mRooms = res.data;
        });

      }
        
    },
  mounted () {
    this.roomList = this.$store.state.mRooms
    console.log(this.mRooms)
    console.log('room')
    console.log(this.roomList)
    console.log(this.$store.state.mRooms)
    this.dates = this.payload.dates
    this.personnel = this.payload.personnel
    
  }
      
};
</script>

<style scoped>
h1{
  font-family: 'NanumSquareRound';  
  color: #202020;
}
#tagSpan1 {
  padding-left: 20px;
  padding-right: 20px;
  background-color: #f8f8f8;
  display: inline-block;
  position: relative;
  border-radius: 20px;
  text-decoration: none;
  margin: 0.7em;
  font-weight: 500;
  font-family: Pretendard,-apple-system,BlinkMacSystemFont,Open Sans,Helvetica Neue,sans-serif;;
  font-size: 12px;
  color: gray;
}

#button2 {
    text-decoration: none;
    background-color: #54658a;
    position: relative;
    padding: 0 15px;
    color: #f8f8f8;
    font-weight: 600;
    font-size: 15px;
    line-height: 29px;
}

#button2:hover {
  background-color: #e63668;
}


/*table, th, td{
    border-collapse:collapse;
    border: 1px solid black;
} */
</style>