<template>
    <v-col class="MainSearch">
        <v-row>
            <v-col cols="12" xs="12" sm="6" md="4">
                <v-menu class="menu1" v-model="calendar" :close-on-content-click="false" transition="scale-transition"
                    offset-y>
                    <template v-slot:activator="{ on, attrs }">
                        <v-text-field class="DateSearch" v-model="dateRangeText" label="날짜 선택"
                            prepend-icon="mdi-calendar" v-bind="attrs" @blur="date = parseDate(dateFormatted)" v-on="on"
                            rounded solo readonly></v-text-field>
                    </template>
                    <v-date-picker v-model="dates" range></v-date-picker>
                </v-menu>
            </v-col>
            <v-col cols="12" xs="12" sm="6" md="4">
                <v-select :items="items" prepend-icon="mdi-bed" label="인원 선택" class="PickPeople" rounded solo>
                </v-select>
            </v-col>
            <v-col cols="12" xs="12" sm="12" md="4">
                <v-text-field class="CitySearch" prepend-icon="mdi-city-variant-outline" label="도시 입력" rounded solo
                    type="city">
                    <template #append>
                        <v-btn type="submit" value="Subscribe">
                            검색하기
                        </v-btn>
                    </template>
                </v-text-field>
            </v-col>
        </v-row>
    </v-col>
</template>

<script>

export default {

    component: {

    },

    data: () => ({
        dates: ['2022-06-13', '2022-06-13'],
        items: ['1', '2', '3', '4'],
        value: null,
    }),
    computed: {
        dateRangeText() {
            return this.dates.join(' ~ ')
        },
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