<template>
    <div class="container" align="center">

        <table>
          <tr>
            <td align="left">
              <h2 class="pageTit"> 예약 및 결제 </h2>
            </td>
          </tr>
          <tr>
            <td>
              <div>
                <m-reserv-form :reservationInfo = "reservationInfo" @payRequest="requestPay"/>
              </div>
            </td>
          </tr>
        </table>

    </div>
</template>

<script>
import MReservForm from '@/components/reserv/MReservForm.vue'
import {v4 as uuidv4} from 'uuid'
import axios from 'axios'
const { IMP } = window

export default {
    data() {
      return {
        reservationInfo: {},
      }
    },
    name: 'MReservPage',
    components: {
      MReservForm
    },
    computed: {
    },
    mounted() {
      const params = new URLSearchParams();
      params.append('reservationId', this.$route.params.no)
      axios.get("http://localhost:7777/reserve/user/readReservation", {params: params})
      .then((res) => this.reservationInfo = res.data)
    },
    methods: {
      requestPay(){
        IMP.init("imp53140629")
        // IMP.request_pay(param, callback) 결제창 호출
        IMP.request_pay({ 
            pg: "html5_inicis",
            pay_method: "card",
            merchant_uid: uuidv4() + this.reservationInfo.id,
            name: uuidv4() + this.reservationInfo.id,
            amount: this.reservationInfo.price,
            buyer_email: this.reservationInfo.email,
            buyer_name: this.reservationInfo.username,
            buyer_tel: this.reservationInfo.mobile
      }, rsp => {
        if (rsp.success){
            const params = { 'imp_uid': rsp.imp_uid, 'merchant_uid': rsp.merchant_uid}

            axios.post("http://localhost:7777/payment/complete", params)
            .then((res) => {

                console.log(res)

                if (res){
                    alert("결제완료")
                } else{
                  // 결제 검증 실패, 환불
                      
                    console.log(params)
                    axios.post("http://localhost:7777/payment/cancel", params)
                    .then(res => {
                      alert("결제검증에 실패하여 결제가 취소되었습니다")
                      console.log(res)})
                }
                    this.$router.push("/")

            })
        } else{
            alert(`결제에 실패하였습니다. 에러 내용: ${rsp.error_msg}`)
            this.$router.push("/")
        }
      })
    }
  }
}
</script>

<style scoped>
.pageTit {
  padding: 30px 0px 0px 0px;
  font-family: 'NanumSquareRound';
  font-size: 2.0rem;
  line-height: 1.25;
  letter-spacing: -.01em;
  color: #202020;
  font-weight: 900;
}
.pageTit:after {
    content: '';
    display: inline-block;
    width: 4px;
    height: 4px;
    margin-bottom: 24px;
    border-radius: 50%;
    background-color: #e63668;
}

/*table, th, td{
    border-collapse:collapse;
    border: 1px solid black;
}*/
</style>