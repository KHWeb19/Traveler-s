<template>
   <div align="center">
      <v-layout justify-center>
            <v-dialog  v-model="findPw" resisten max-width="800px">
               <template v-slot:activator="{ on }">
               <v-btn style="color: black" v-on="on">
                  상세보기
               </v-btn>
               </template>
               <v-card align="center">
                  <v-card-title id="title">
                     {{reserv.name}} 고객님 예약정보
                  </v-card-title>

                  <form>

   <!-- disabled는 컨트롤러로 값이 넘어오지 않는다.
      readonly를 사용하면 입력만 막고 값은 넘길 수 있다. -->

                     <table>
                        <tr>
                           <td>
                              예약번호
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" value="reserv.reservNo" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              예약자명
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" value="reserv.name" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              휴대폰 번호
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" value="reserv.telNum" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              이메일
                           </td>
                           <td>
                              &ensp;
                              <input type="email" id="cantTouch" value="reserv.email" readonly/>
                           </td> <!--  텍스트 입력 필드처럼 보이지만 유효성 검증 매개변수가 존재 -->
                        </tr>

                        <tr>
                           <td>
                              체크인
                           </td>
                           <td>
                              &ensp;
                              <input type="date" id="cantTouch" value="reserv.check_in" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              체크아웃
                           </td>
                           <td>
                              &ensp;
                              <input type="date" id="cantTouch" value="reserv.check_out" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              요금
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" value="reserv.price" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              고객 요청사항
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" style="height: 200px;" value="reserv.content" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              객실
                           </td>
                        </tr>
                        <tr>
                           <td colspan="2">
                           <table align="center" style="width: 700px;">
                              <tr>
                                 <th align="center" width="130">날짜</th>
                                 <th align="center" width="170">객실명</th>
                                 <th align="center" width="100">요금</th>
                                 <th align="center" width="60">인원</th>
                                 <th align="center" width="40">&ensp;&ensp;</th>                                 
                              </tr>

                              <tr>
                                 <td  align="center">
                                    <span>{{reserv.check_in}} ~ &ensp;
                                    <br> &ensp; {{reserv.check_out}}</span>
                                 </td>
                                 <td  align="center">
                                    <span>{{reserv.room_name}}</span>
                                 </td>                                 
                                 <td  align="center">
                                    <span>{{reserv.price}}</span>
                                 </td>
                                 <td  align="center">
                                    <input type="number" id="cantTouch" value="reserv.personnel" style="width: 40px;" readonly/>
                                 </td>
                                 <td  align="center">
                                    <v-btn id="delButton" @click="onDelete">
                                       X
                                    </v-btn>
                                 </td>
                              </tr>
                           </table>
                           </td>
                        </tr>
                     </table>
                  </form>
               <br>
                  <v-card-actions>
                     <v-spacer></v-spacer>
                     <v-btn>
                           수정
                     </v-btn>
                     <v-btn @click.stop="$emit('close')">
                           닫기
                     </v-btn>
                     <v-spacer></v-spacer>
                  </v-card-actions>
               </v-card>
            </v-dialog>
      </v-layout>
   </div>    
</template>

<script>
import axios from 'axios'

export default {
   name: 'reservDatail',
   props: {
      reserv: {
         type: Object,
         required: true
      }
   },
   created() {
      this.reservNo = this.reserv.reservNo
   },
   methods: {
      onDelete () {
            const { reservNo } = this.reserv
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/reserv/${reservNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'ManageReservList' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }        
   }
}
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