<script lang="ts">
  import {t} from 'i18n'
  import Toasts from 'src/components/Toasts.svelte'
  import {navigate, Route, Router} from 'svelte-routing'
  import Compass from 'src/pages/Compass.svelte'
  import {onMount} from 'svelte'

  onMount(() => {
    navigate('/tallinn2025')
  })
</script>

<svelte:head>
  <title>{t.title}</title>
</svelte:head>

<Toasts/>

<main class="text-center pt-10">
  <h1>{t.title}</h1>

  <Router>
    <Route path="/tallinn2025" component={Compass}/>
  </Router>
</main>
