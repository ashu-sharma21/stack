static int prec(char c)
{
  switch(c)
  {
    case '+':
      case'-':
        return 1;
    case '*':
    case '/':
      return 2;
    case '^':
      return 3;
    default:
      return 0;
  }
}
static String infixToPostfix(CQStack s, String exp)
{
  String res="";
  for(int i=0;i<exp.length();i++)
  {
    char c= exp.charAt(i);
    if(Character.isLetterOrDigit(c))
      res+=c;
    else if(c=='(')
      s.push(c);
    else if(c==')')
    {
      while(!s.isEmpty() && s.stackArray[s.top] !='(')
        res+=(char)s.pop();
      if(!s.isEmpty())
        s.pop();
    }
    else
    {
      while(!s.isEmpty() && prec((char)s.stackArray[s.top])>=prec(c))
        res+=(char)s.pop();
      s.push(c);
    }
  }
      while(!s.isEmpty())
            res+=(char)s.pop();
  return res;
}
