<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.1">
  <xsl:output indent="yes" />
  <xsl:param name="isValid"/>
  <xsl:template match="/">
 
<html>
  <body>

    <table class="tableView">
      <tr>
        <td class="heading" colspan="2">isValid:  <xsl:value-of select="$isValid"/></td>
      </tr>
      <tr>
        <td class="heading" colspan="2">TotalCost: <xsl:value-of select="purchaseOrder/details/totalCost"/></td>
     </tr>
     <tr>
        <td class="heading" colspan="2">PONum:  <xsl:value-of select="purchaseOrder/header/PONumber"/></td>
      </tr>

      <tr>
	<td class="oddcol">Description</td>
	<td class="oddcol">Quantity</td>
      </tr>
      <xsl:for-each select="purchaseOrder/details/orderLineItems">
	<tr>
	  <td class="oddrowdata-r">
	    <xsl:value-of select="desc"/>
	  </td>
	  <td class="oddrowdata-l">
	    <xsl:value-of select="quantity"/>
	  </td>
	</tr>
      </xsl:for-each>
    </table>
   </body>
</html>

    
  </xsl:template>
</xsl:stylesheet>
