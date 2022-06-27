<template>
    <v-col class="MainSearch">
        <v-col>
            <v-btn><a href="/BHotelListPage">HotelListPage</a></v-btn><p />
            <v-btn><a href="/BHotelRegisterPage">hotelRegister</a></v-btn><p />
            <v-btn><a href="/mypage">mypage</a></v-btn><p />
            <v-btn><a href="/roomRegister">roomRegister</a></v-btn><p />
        </v-col>
        <v-row>
            <v-col cols="12" xs="12" sm="6" md="4">
                <v-menu class="menu1" :close-on-content-click="false" transition="scale-transition"
                    offset-y>
                    <template v-slot:activator="{ on, attrs }">
                        <v-text-field class="DateSearch"  label="날짜 선택" v-model="planDate"
                            prepend-icon="mdi-calendar" v-bind="attrs" v-on="on"
                            rounded solo readonly></v-text-field>
                    </template>
                    <v-date-picker v-model="dates" 
                                    :min="new Date().toISOString().substr(0, 10)" range
                                    >
                    </v-date-picker>
                </v-menu>
            </v-col>
            <v-col cols="12" xs="12" sm="6" md="4">
                <v-select v-model="personnel" :items="items" item-value="value" prepend-icon="mdi-bed" label="인원 선택" class="PickPeople" rounded solo>
                </v-select>
            </v-col>
            <v-col cols="12" xs="12" sm="12" md="4">
                <v-text-field v-model="city" class="CitySearch" prepend-icon="mdi-city-variant-outline" label="도시 입력" rounded solo
                    type="city">
                    <template #append>
                        <v-btn @click="searchPage()" type="submit" value="Subscribe">
                            검색하기
                        </v-btn>
                    </template>
                </v-text-field>
            </v-col>
        </v-row>
    </v-col>
</template>

<script>
import axios from 'axios'

export default {
    name: 'MainSearch',
    props:{
        hotels:{
            type: Array
        }
    },
    component: {
    },
    data: () => ({
        dates: [],
        items: ['1', '2', '3', '4'],
        value: null,
        personnel: '',
        city:''
    }),
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
        searchPage() {
            console.log(this.dates)
            const { dates, personnel , city} = this
            axios.post('http://localhost:7777/search/commonSearch', {dates, personnel, city})
                    .then((res) => {
                        console.log("검색 성공")
                        console.log(res.data)
                        
                        
                        this.$router.push({name: 'CommonSearchPage',
                                    params: { searchList: res.data } })
                    .catch(() => {});
                })
                .catch(() => {
                alert("검색 실패");
            });
           
        },
        initDates() {
            return this.dates = []
        }
    },
}
</script>

<style scoped>
.MainSearch{
    margin-top: 9%;
    margin-bottom: 5%;
    margin-right: 5%;
    margin-left: 5%;
}
.DateSearch {
    min-width: 260px;
    max-width: 150%;
}

.PickPeople {
    min-width: 260px;
    max-width: 100%;
}

.CitySearch {
    min-width: 260px;
    max-width: 150%;
}

.v-btn {
    color: rgb(55, 55, 55);
    width: 20px;
    font-size: 5px;
}
</style>