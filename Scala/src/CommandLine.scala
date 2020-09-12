import scala.io.StdIn.readLine

object CommandLine {
  def askForInput(question: String) : String = {
    print(question + ": ")
    readLine()
  }

  val options : Map[String, CommandLineOption] = Map(
    "1" -> new CommandLineOption("Add Customer", Customer.createCustomer),
    "2" -> new CommandLineOption("List Customers", Customer.list),
    "3" -> new CommandLineOption("List enabled Contacts for Enabled Customers",
    () => Customer.eachEnabledContact(contact => println(contact))),
    "q" -> new CommandLineOption("Quit", sys.exit)
  )

  def prompt() = {
    options.foreach(option => println(option._1 + ") " + option._2.description))
    options.get(askForInput("Option").trim.toLowerCase) match {
      case Some(CommandLineOption(_, exec)) => exec()
      case _ => println("Invalid input")
    }
  }
}



class CommandLine {

}

case class CommandLineOption(description: String, func: () => Unit)