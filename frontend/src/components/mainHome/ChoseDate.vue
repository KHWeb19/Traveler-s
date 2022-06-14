<template>
      <v-col cols="12" sm="3">
        <v-menu class="menu1" v-model="calendar" :close-on-content-click="false" transition="scale-transition" offset-y
          max-width="290px" min-width="auto" >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field v-model="dateRangeText" label="날짜 선택" prepend-icon="mdi-calendar" v-bind="attrs"
              @blur="date = parseDate(dateFormatted)" v-on="on" rounded solo readonly></v-text-field>
          </template>
          <v-date-picker v-model="dates" range></v-date-picker>
        </v-menu>
      </v-col>
</template>

<script>
  export default {
    data: () => ({
      dates: ['2022-06-13', '2022-06-13'],
    }),
    computed: {
      dateRangeText () {
        return this.dates.join(' ~ ')
      },
    },
  }
</script>

<style scoped>

</style>
