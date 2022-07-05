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
                <m-reserv-form/>      
              </div>
            </td>
          </tr>
        </table>

    </div>
</template>

<script>
import MReservForm from '@/components/reserv/MReservForm.vue'

//import { mapState, mapActions } from 'vuex'
//import axios from 'axios'

export default {
    name: 'MReservPage',
    components: {
      MReservForm
    },
    computed: {

    },
    mounted() {

    },
    methods: {

    },
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