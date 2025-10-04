import et from './et.json'
import langs from './langs.json'
export {langs}

export function changeLang(lang: typeof langs[number]) {
  localStorage['lang'] = lang
  location.reload()
}

export function resolve(key: string, from: Record<string, any> = t): any {
  return key.split('.').reduce((acc, key) => acc && acc[key], from)
}

function choosePreferredLang() {
  let lang = localStorage['lang'] ?? navigator.language.split('-')[0]
  return langs.includes(lang) ? lang : langs[0]
}

async function load() {
  if (lang === 'et') return et
  if (lang === 'ru') return mergeDicts((await import('./ru.json')).default, et)
  else throw new Error('Unsupported lang: ' + lang)
}

export const lang = choosePreferredLang()
export let t: typeof et = await load()

function mergeDicts(dict, defaultDict, noTranslate = new Set(), parent = '') {
  for (const key in defaultDict) {
    const fullKey = (parent ? parent + '.' : '') + key
    if (typeof dict[key] === 'object' && typeof defaultDict[key] === 'object')
      dict[key] = mergeDicts(dict[key], defaultDict[key], noTranslate, fullKey)
    else if (!dict[key]) {
      dict[key] = defaultDict[key]
      if (!noTranslate.has(fullKey))
        console.warn(`  added missing ${fullKey}`)
    }
  }
  return dict
}
