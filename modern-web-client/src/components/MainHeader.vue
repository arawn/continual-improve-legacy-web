<template>
    <div class="mb-auto">
        <header class="masthead">
            <div class="inner">
                <h3 class="masthead-brand">Demo</h3>
                <nav class="nav nav-masthead justify-content-center">
                    <a href="/index.jsp" v-bind:class="menuItemClass('/index.jsp')">Index</a>
                    <a href="/order.jsp" v-bind:class="menuItemClass('/order.jsp')">Order</a>
                    <a href="/support.jsp" v-bind:class="menuItemClass('/support.jsp')">Support</a>
                </nav>
            </div>
        </header>
    </div>
</template>

<script>
    const baseURI = '/api/items'

    export default {
        data() {
            return {
                items: []
            }
        },
        mounted() {
            this.fetch()
        },
        methods: {
            fetch() {
                this.$http.get(`${baseURI}`).then(response => {
                    console.log(response)
                })
            },
            menuItemClass(path) {
                return {
                    'nav-link': true,
                    'active': this.$route.path === path
                }
            }
        }
    }
</script>

<style scoped>

</style>