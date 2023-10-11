import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import nameAndTerm from "@/store/TermModel/nameAndTerm"

export default new Vuex.Store({
  state: {
    name: '',
    term: ''
  },
  mutations: {
    setName(state, name) {
        state.name = name
    },
    setTerm(state, term) {
        state.term = term
    }
  },
  actions: {
  },
  modules: {
    nameAndTerm
  }
})
