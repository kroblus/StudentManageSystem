const state = {
    name: '',
    term: '',
}
const mutations = {
    setName(state, name) {
        state.name = name
    },
    setTerm(state, term) {
        state.term = term
    }
}
const actions = {
    setName({ commit }, name) {
        commit('setName', name)
    },
    setTerm({ commit }, term) {
        commit('setTerm', term)
    }
}
const getters = {
    name: state => state.name,
    term: state => state.term
}
export default {
    state,
    mutations,
    actions,
    getters
}