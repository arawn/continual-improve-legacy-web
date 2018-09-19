<template>
    <div id="app">
        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
            <main-header></main-header>
            <main role="main" class="inner cover">
                <router-view/>
            </main>
            <main-footer></main-footer>
        </div>
    </div>
</template>

<script>
    import MainHeader from './components/MainHeader.vue'
    import MainFooter from './components/MainFooter.vue'

    export default {
        name: 'app',
        components: {
            MainHeader, MainFooter
        },
        methods: {

        }
    }
</script>

<style scoped>

</style>
