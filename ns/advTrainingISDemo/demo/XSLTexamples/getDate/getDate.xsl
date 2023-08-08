<?xml version="1.0" ?>
<xsl:stylesheet version="1.1" 
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:Output="java://com.wm.pkg.xslt.extension.Output"
		xmlns:Date="java://java.util.Date"
		xmlns:IntDate="java://com.wm.pkg.xslt.samples.date.IntDate"
		exclude-result-prefixes="Output Date IntDate">

  <xsl:param name="output"/>
  <xsl:param name="year"/>
  <xsl:param name="month"/>
  <xsl:param name="day"/>
  <xsl:param name="hour"/>
  <xsl:param name="minute"/>
  <xsl:param name="second"/>
  <xsl:param name="date" select="IntDate:getDate($year,$month,$day,$hour,$minute,$second)"/>
  <xsl:output method="xml" indent="yes" />
  
  <xsl:template match="/" >
    <xsl:value-of select="Output:put($output, 'year', $year)" />
    <xsl:value-of select="Output:put($output, 'month', $month)" />
    <xsl:value-of select="Output:put($output, 'day', $day)" />
    <xsl:value-of select="Output:put($output, 'hour', $hour)" />
    <xsl:value-of select="Output:put($output, 'minute', $minute)" />
    <xsl:value-of select="Output:put($output, 'second', $second)" />
    <xsl:value-of select="Output:put($output, 'date', $date)" />
    <xsl:apply-templates />
  </xsl:template> 

  <!-- Default template. Just copies the element (with attributes) to the output. -->
  <xsl:template match="*">
    <xsl:element name="{name()}">
      <xsl:apply-templates />
    </xsl:element>
  </xsl:template>

  <xsl:template match="date" xml:space="preserve">
    <xsl:text>year   : </xsl:text><xsl:value-of select="$year"/>
    <xsl:text>month  : </xsl:text><xsl:value-of select="$month"/>
    <xsl:text>day    : </xsl:text><xsl:value-of select="$day"/>
    <xsl:text>hour   : </xsl:text><xsl:value-of select="$hour"/>
    <xsl:text>minute : </xsl:text><xsl:value-of select="$minute"/>
    <xsl:text>second : </xsl:text><xsl:value-of select="$second"/>

    <xsl:text>converts to</xsl:text>

    <xsl:value-of select="Date:toString($date)"/>
  </xsl:template>

</xsl:stylesheet>
