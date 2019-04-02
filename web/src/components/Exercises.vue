<template>
    <div>
        <div v-bind:key="exercise.id" v-for="exercise in exercises">
            <ExerciseItem v-bind:exercise="exercise"/>
        </div>
    </div>
</template>

<script>
    import ExerciseItem from './ExerciseItem';
    export default {
        name: "Exercises",
        components: {
            ExerciseItem
        },
        props: ["exercises"]
    }
</script>

<style scoped>
</style>