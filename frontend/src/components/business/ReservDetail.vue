<template>
  <div align="center">
    <v-layout justify-center>
      <!-- 쓰는 파일 -->
      <v-dialog v-model="dialog" width="800px">
        <template v-slot:activator="{ on }">
          <v-btn style="color: black" v-on="on"> 상세보기 </v-btn>
        </template>
        <v-card align="center">
          <v-card-title id="title">
            {{ bookingData.username }} 고객님 예약정보
          </v-card-title>

          <form>
            <!-- disabled는 컨트롤러로 값이 넘어오지 않는다.
      readonly를 사용하면 입력만 막고 값은 넘길 수 있다. -->

            <table>
              <tr>
                <td>예약번호</td>
                <td>
                  &ensp;
                  <input type="text" id="cantTouch" v-model="id" readonly />
                </td>
              </tr>

              <tr>
                <td>예약자명</td>
                <td>
                  &ensp;
                  <input
                    type="text"
                    id="cantTouch"
                    v-model="userName"
                    readonly
                  />
                </td>
              </tr>

              <tr>
                <td>휴대폰 번호</td>
                <td>
                  &ensp;
                  <input
                    type="text"
                    id="cantTouch"
                    value="010-0000-0000"
                    readonly
                  />
                </td>
              </tr>

              <tr>
                <td>이메일</td>
                <td>
                  &ensp;
                  <input
                    type="email"
                    id="cantTouch"
                    v-model="userEmail"
                    readonly
                  />
                </td>
                <!--  텍스트 입력 필드처럼 보이지만 유효성 검증 매개변수가 존재 -->
              </tr>

              <tr>
                <td>체크인</td>
                <td>
                  &ensp;
                  <input type="date" id="cantTouch" v-model="start" readonly />
                </td>
              </tr>

              <tr>
                <td>체크아웃</td>
                <td>
                  &ensp;
                  <input type="date" id="cantTouch" v-model="end" readonly />
                </td>
              </tr>

              <tr>
                <td>요금</td>
                <td>
                  &ensp;
                  <input type="text" id="cantTouch" v-model="price" readonly />
                </td>
              </tr>

              <tr>
                <th>객실</th>
                <br />
              </tr>
              <tr>
                <td colspan="2">
                  <table align="center" style="width: 700px">
                    <tr>
                      <th align="center" width="130">날짜</th>
                      <th align="center" width="170">객실명</th>
                      <th align="center" width="100">요금</th>
                      <th align="center" width="60">인원</th>
                      <th align="center" width="40">&ensp;&ensp;</th>
                    </tr>

                    <tr>
                      <td align="center">
                        <span
                          >{{ bookingData.startDate }} ~ &ensp; <br />
                          &ensp; {{ bookingData.endDate }}</span
                        >
                      </td>
                      <td align="center">
                        <span>{{ bookingData.roomType }}</span>
                      </td>
                      <td align="center">
                        <span>{{ bookingData.price }}</span>
                      </td>
                      <td align="center">
                        <span>{{ bookingData.personnel }}</span>
                        <!--고객이 아니라 객실 등록할 때 입력된 객실 최대인원수 가 원래의 시나리오
                                    하지만 그냥 고객이 예약한 인원수로 바꿔도 상관없습니다. -->
                      </td>
                      <td align="center">
                        <v-btn id="delButton" @click="onDelete"> X </v-btn>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </form>
          <br />
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn> 수정 </v-btn>
            <v-btn @click="cancel"> 닫기 </v-btn>
            <v-spacer></v-spacer>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-layout>
  </div>
</template>

<script>
//import axios from 'axios'

export default {
  name: "reservDatail",
  props: ["bookingData"],
  data() {
    return {
      dialog: false,
      id: this.bookingData.id,
      userName: this.bookingData.username,
      userEmail: this.bookingData.email,
      start: this.bookingData.startDate,
      end: this.bookingData.endDate,
      price: this.bookingData.price,
    };
  },
  created() {},
  methods: {
    cancel() {
      this.dialog = false;
    },
    onDelete() {},
  },
};
</script>

<style scoped>
#cantTouch {
  border: 1px solid gray;
  padding: 4px;
  border-radius: 4%;
  width: 500px;
  outline: none;
}
#delButton {
  padding: 25px;
  border-radius: 50px;
  background-color: brown;
  color: white;
  font-size: 20px;
}
</style>
