
package kotlinWebJS

import kotlin.browser.document

// using JQUERY on kotlin, memo: import jquery library!
@native("$")
val jquery : dynamic = noImpl

fun main(args: Array<String>) {

    // creating a Kotlin application that compiles down to JavaScript

    val el = document.createElement("div")
    el.appendChild(document.createTextNode("example"))
    document.body!!.appendChild(el)

    val playersFromApi = "http://localhost:8080/"
    // to do: fix the getJSON call -> No 'Access-Control-Allow-Origin' header is present on the requested resource. Origin 'null' is therefore not allowed access
    jquery.getJSON(playersFromApi) { players ->
        val playersTable = jquery("#playersTable")
        players.forEach { player ->
            playersTable.append("""
                    <tr>
                        <td><a href=${player.username}>${player.nickname}</a></td>
                    </tr>""")
        }
    }


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