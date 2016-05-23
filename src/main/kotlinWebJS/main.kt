
package kotlinWebJS
import kotlin.browser.document

fun main(args: Array<String>) {

    // creating a Kotlin application that compiles down to JavaScript

    val el = document.createElement("div")
    el.appendChild(document.createTextNode("Hello!"))
    document.body!!.appendChild(el)

    // ---------------------------------------------------------------
    println("kotlin from js:")
    println("equivalent to 'console.log()' ¿? yes and no, look at the result on ../web/js/app.js")
    // ---------------------------------------------------------------
    js("console.log('js from kotlin:')")
    val explanation = "" +
            "Language Injection support in IntelliJ IDEA for Kotlin. " +
            "And while this applies to any string and any language, " +
            "not just JavaScript, it definitely proves useful when using js, " +
            "allowing this.."
    js("console.log('${explanation}')") // Language Injection: func 'js'
}